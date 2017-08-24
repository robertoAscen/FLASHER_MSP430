/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.file;

import com.eneri.eneriflashertool.firmware.IntelHEXLine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Roberto Ascencio
 */
public class HandlerFiles 
{
    private JFileChooser jfChooser;
    private File fileName;
    private FileWriter fileWrite = null;
    private JTextArea jtArea;
    private JPanel jpMessages;
    private String path;    
    private JFileChooser jFileChooser;
    private JPanel jPanel;
    private FileReader fr;
    private BufferedReader br;
    private PrintWriter pw;
    private String strContenido;
    private String[] guardarStr = new String[143];
    private IntelHEXLine hexLine;
    
    public String setPathLog()
    {
    	String path = null;
    	
    	jFileChooser = new JFileChooser();
    	jPanel = new JPanel();
    	
    	jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);    	
    	int select = jFileChooser.showOpenDialog(jPanel);
    	switch(select)
    	{
            case 0:
                path = String.valueOf(jFileChooser.getSelectedFile().getAbsolutePath());
            break;
            case 1:
                JOptionPane.showMessageDialog(null, "Selecciona un directorio para guardar el log");
            break;
            case 2:
                JOptionPane.showMessageDialog(null, "Ocurrio un error al elejir un directorio para guardar el log");
            break;            
    	}    	
    	
    	return path;
    }
    
    public void writeLog(String log, String nameFile, String status)
    {
    	fileName = new File("C:/Flasher_G155_LOG/");
        if(!fileName.exists())
        {
            fileName.mkdir();
            JOptionPane.showMessageDialog(null, "Se creo la carpeta para guardar el log en C:/Flasher_G155_LOG/");
            try 
            {
                pw = new PrintWriter(new FileWriter(fileName+"/"+nameFile+"-"+status+".txt"));
    		pw.println(log);
            } 
            catch (IOException e) 
            {
            	// TODO Auto-generated catch block
    		e.printStackTrace();
            }            
            pw.close();
        }
        else
        {
            try 
            {
                pw = new PrintWriter(new FileWriter(fileName+"/"+nameFile+"-"+status+".txt"));
    		pw.println(log);
            } 
            catch (IOException e) 
            {
                // TODO Auto-generated catch block
    		e.printStackTrace();
            }            
            pw.close();
        }    	
    }
    
    public void writeLoader(String[] strChange)
    {
        try 
        {
            fileName = new File("Firmware/Loader.hex");//esta se debe activar cuando se realize el instalador
            //fileName = new File("h:\\NETBEANS\\EneriFlasherTool\\src\\main\\resources\\Firmware\\Loader.hex");
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for(int i=0; i<strChange.length; i++)
            {
                pw.println(strChange[i]);
            }
            pw.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] modifyLoader(String SnToChange)
    {
        try 
        {
            fileName = new File("Firmware/Loader.hex");//esta se debe activar cuando se realize el instalador
            //fileName = new File("h:\\NETBEANS\\EneriFlasherTool\\src\\main\\resources\\Firmware\\Loader.hex");
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            int cont = 0;
            
            while((strContenido = br.readLine())!=null)
            {
                if(cont == 0)
                {
                    hexLine = new IntelHEXLine(strContenido.substring(0, 9)+SnToChange+strContenido.substring(25, 69));
                    guardarStr[cont] = strContenido.substring(0, 9)+SnToChange+strContenido.substring(25, 69)+hexLine.getChecksum();                    
                }
                else
                {
                    guardarStr[cont] = strContenido;
                }                
                cont++;
            }
            br.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return guardarStr;
    }    
    
    private void writeFile(String path, String completeLog)
    {
        this.path = path;
        fileName = new File(path); 
        if(fileName.exists())
        {
            int request = JOptionPane.showConfirmDialog(null, "Replace existing file?");
            switch(request)
            {
                case 0:
                    try 
                    {
                        fileWrite = new FileWriter(fileName);
                        BufferedWriter bw = new BufferedWriter(fileWrite);                        
                        bw.append(completeLog);
                        bw.newLine();
                        bw.close();
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;            
            }           
        }
        else
        {
            try 
            {
                fileWrite = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fileWrite);                        
                bw.append(completeLog);
                bw.newLine();
                bw.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(HandlerFiles.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public void xportFile(String logComplete)
    {
        jfChooser = new JFileChooser();
        jpMessages = new JPanel();
        jfChooser.showSaveDialog(jpMessages);
        if(jfChooser.getSelectedFile() != null)
        {
            writeFile(jfChooser.getSelectedFile()+".txt", logComplete);
            JOptionPane.showMessageDialog(null, "Saved File");
        }
    }  
}
