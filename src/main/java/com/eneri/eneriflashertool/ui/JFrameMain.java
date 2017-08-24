/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.ui;

import com.eneri.eneriflashertool.Eject.HandlerTerminal;
import com.eneri.eneriflashertool.file.HandlerFiles;
import com.eneri.eneriflashertool.firmware.Convertions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Roberto Ascencio
 */
public class JFrameMain extends JFrame
{
    private JMenuBar jMenuBar;
    private JMenu jmConfigurations;
    private JMenu jmFlasher;	
    private JMenu jmHelp;
    private JMenuItem jmiSaveLog;
    private JMenuItem jmiExit;
    private JMenuItem jmiProgramar;
    private JMenuItem jmiLimpiarLog;
    private JMenuItem jmiAbout;
    private JMenuItem jmiHelp;
    private JPanel jpFlasher;
    private TitledBorder border;
    private JScrollPane jScrollPane;
    private JTextArea areaTerminal;
    private JButton btnProgramar;
    private JButton btnLimpiar;
    private HandlerTerminal mnjTerminal;
    private JTextField snFabric;
    private JLabel jlsnFabric;
    private HandlerFiles hFiles;
    private Convertions convertion;
    private ImageIcon iIcon;
	
    public JFrameMain()
    {
    	initComponents();
    }
	
    public void initComponents()
    {	
        jpFlasher = new JPanel(null);
        border = new TitledBorder("Flasher G155");
	areaTerminal = new JTextArea();
	jScrollPane = new JScrollPane(areaTerminal);
	btnProgramar = new JButton("Programar");
	btnLimpiar = new JButton("Limpiar Log");
	mnjTerminal = new HandlerTerminal();
	snFabric = new JTextField();
	jlsnFabric = new JLabel("SN Fabricación");
	hFiles = new HandlerFiles();
	convertion = new Convertions();
	jMenuBar = new JMenuBar();
	jmConfigurations = new JMenu("Configuración");
	jmFlasher = new JMenu("Flasher");	
	jmHelp = new JMenu("Ayuda");
	jmiSaveLog = new JMenuItem("Guardar Log");
	jmiExit = new JMenuItem("Salir");
	jmiProgramar = new JMenuItem("Programar");
	jmiLimpiarLog = new JMenuItem("Limpiar Log");
	jmiAbout = new JMenuItem("Acerca de...");
        jmiHelp = new JMenuItem("Ayuda");
        //iIcon = new ImageIcon("h:\\NETBEANS\\EneriFlasherTool\\src\\main\\resources\\image\\ImageEneri.png");
        iIcon = new ImageIcon("image/ImageEneri.png");
        
	
        jlsnFabric.setBounds(10, 20, 100, 25);
	snFabric.setBounds(10, 40, 100, 25);
	jScrollPane.setBounds(10, 80, 570, 410);
	btnProgramar.setBounds(320, 40, 120, 25);
	btnLimpiar.setBounds(460, 40, 120, 25);
		
	jpFlasher.setBorder(border);
	areaTerminal.setBackground(Color.black);              //Configuration JTextArea
	areaTerminal.setForeground(Color.GREEN);             //Configuration JTextArea
	areaTerminal.setLineWrap(true);                       //Configuration JTextArea
	areaTerminal.setWrapStyleWord(true);
        
        jmiSaveLog.setAccelerator(KeyStroke.getKeyStroke("control S"));
        jmiExit.setAccelerator(KeyStroke.getKeyStroke("control E"));
        jmiProgramar.setAccelerator(KeyStroke.getKeyStroke("control P"));
        jmiLimpiarLog.setAccelerator(KeyStroke.getKeyStroke("control L"));
        jmiAbout.setAccelerator(KeyStroke.getKeyStroke("control A"));
        jmiHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
        		
	add(jMenuBar, BorderLayout.NORTH);
	jMenuBar.add(jmConfigurations);
	jMenuBar.add(jmFlasher);
	jMenuBar.add(jmHelp);
	jmConfigurations.add(jmiSaveLog);
	jmConfigurations.add(jmiExit);
	jmFlasher.add(jmiProgramar);
	jmFlasher.add(jmiLimpiarLog);
        jmHelp.add(jmiHelp);
	jmHelp.add(jmiAbout);        
	
	add(jpFlasher, BorderLayout.CENTER);
	jpFlasher.add(jScrollPane);
	jpFlasher.add(btnProgramar);
	jpFlasher.add(btnLimpiar);
	jpFlasher.add(snFabric);
	jpFlasher.add(jlsnFabric);
	
	btnProgramar.addActionListener(new ActionListener()
	{			
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
            	// TODO Auto-generated method stub
            	btnProgramarPerformed(evt);
            }
        });
		
	jmiProgramar.addActionListener(new ActionListener()
	{			
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
		// TODO Auto-generated method stub
		jmiProgramarPerformed(evt);
            }
	});
		
        btnLimpiar.addActionListener(new ActionListener()
	{			
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                // TODO Auto-generated method stub
		btnLimpiarPerformed(evt);
            }
        });
		
	jmiLimpiarLog.addActionListener(new ActionListener()
	{			
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
		// TODO Auto-generated method stub
		jmiLimpiarLogPerformed(evt);
            }
	});
		
	jmiExit.addActionListener(new ActionListener()
	{			
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                // TODO Auto-generated method stub
		jmiExitPerformed(evt);
            }
	});
                
	jmiHelp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                jmiHelpActionPerformed(ae);
            }
        });
                
        jmiAbout.addActionListener(new ActionListener()
        {			
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                // TODO Auto-generated method stub
                jmiAboutPerformed(evt);
            }
        });

        jmiSaveLog.addActionListener(new ActionListener()
        {			
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                // TODO Auto-generated method stub
                jmiSaveLogPerformed(evt);
            }
        });
		
	setSize(600, 550);
	setResizable(false);
	setTitle("Eneri_MSP430Flasher Ver. 0.0.1");
               setDefaultCloseOperation(EXIT_ON_CLOSE);		
    }
	
    private void jmiSaveLogPerformed(ActionEvent evt)
    {
        hFiles.xportFile(areaTerminal.getText());
    }
        
    private void jmiHelpActionPerformed(ActionEvent evt)
    {
        //String manual = "h:\\NETBEANS\\EneriFlasherTool\\src\\main\\resources\\Help\\ReadMe.txt";
        String manual = "Help/ReadMe.txt";//Este es para el instalador
      
        try 
        {
            Runtime.getRuntime().exec("cmd /c start "+manual);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    private void jmiAboutPerformed(ActionEvent evt)
    {
        JOptionPane.showMessageDialog(null, "Eneri_Flasher_Tool\nENERI\nwww.eneri.com.mx\nVer. 0.0.1\n12-01-2017","Información",JOptionPane.INFORMATION_MESSAGE,iIcon);
    }
    private void jmiExitPerformed(ActionEvent evt)
    {
	dispose();
    }
	
    private void btnLimpiarPerformed(ActionEvent evt)
    {
	areaTerminal.setText("");
    }
	
    private void jmiLimpiarLogPerformed(ActionEvent evt)
    {
        areaTerminal.setText("");
    }
	
    private void jmiProgramarPerformed(ActionEvent evt)
    {
        if(snFabric.getText().equals(""))
	{
            JOptionPane.showMessageDialog(null, "Scanea un número de fabricación del medidor!!!");
	}
	if(snFabric.getText().length()<8)
	{
            JOptionPane.showMessageDialog(null, "número de fabricación del medidor invalido!!!");
	}
	if(snFabric.getText().length()>8)
	{
            JOptionPane.showMessageDialog(null, "número de fabricación del medidor invalido!!!");
	}
	else if(snFabric.getText().length()==8)
	{
            String str = convertion.getHexSNF(snFabric.getText());
	    String[] yaCambiado = hFiles.modifyLoader(str);//poner este
	    hFiles.writeLoader(yaCambiado);//poner este
            String regreso = mnjTerminal.exeCommand();			
            System.out.println(regreso);
            areaTerminal.append(regreso);
            if(regreso.contains("* Verified    : TRUE"))
            {
                hFiles.writeLog(regreso, snFabric.getText(), "PASS");
		JOptionPane.showMessageDialog(null, "PASS");
		snFabric.setText("");
		System.out.println("pass");
            }
            else
            {
                hFiles.writeLog(regreso, snFabric.getText(), "FAIL");
		JOptionPane.showMessageDialog(null, "FAIL");
		snFabric.setText("");
		System.out.println("fail");
            }			
	}
    }
	
    private void btnProgramarPerformed(ActionEvent evt)
    {
        if(snFabric.getText().equals(""))
	{
            JOptionPane.showMessageDialog(null, "Scanea un número de fabricación del medidor!!!");
	}
        if(snFabric.getText().length()<8)
	{
            JOptionPane.showMessageDialog(null, "número de fabricación del medidor invalido!!!");
	}
	if(snFabric.getText().length()>8)
	{
            JOptionPane.showMessageDialog(null, "número de fabricación del medidor invalido!!!");
	}
	else if(snFabric.getText().length()==8)
	{
            String str = convertion.getHexSNF(snFabric.getText());
	    String[] yaCambiado = hFiles.modifyLoader(str);//poner este
	    hFiles.writeLoader(yaCambiado);//poner este
            String regreso = mnjTerminal.exeCommand();			
            System.out.println(regreso);
            areaTerminal.append(regreso);
            if(regreso.contains("* Verified    : TRUE"))
            {
                hFiles.writeLog(regreso, snFabric.getText(), "PASS");
            	JOptionPane.showMessageDialog(null, "PASS");
		snFabric.setText("");
		System.out.println("pass");
            }
            else
            {
		hFiles.writeLog(regreso, snFabric.getText(), "FAIL");
		JOptionPane.showMessageDialog(null, "FAIL");
		snFabric.setText("");
                System.out.println("fail");
            }			
	}		
    }    
}
