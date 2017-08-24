/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.Eject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Roberto Ascencio
 */
public class HandlerTerminal
{
    private StringBuffer output;
    
    public String exeCommand()
    {
        try 
	{
            output = new StringBuffer();
            Runtime runTime = Runtime.getRuntime();
            //Process p = runTime.exec("MSP430Flasher -n MSP430FE42x2 -w c:\\Users\\Roberto Ascencio\\Downloads\\FWLOADER\\Loader.hex -v");
            //Process p = runTime.exec("MSP430Flasher -n MSP430FE42x2 -w c:\\Program Files\\Eneri_Flasher_Tool\\Firmware\\Loader.hex -v");//para instalador 32 bits solamente
            Process p = runTime.exec("MSP430Flasher -n MSP430FE42x2 -w c:\\Program Files (x86)\\Eneri_Flasher_Tool\\Firmware\\Loader.hex -v");//para instalador 32/64 bits solamente
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while((line = reader.readLine()) != null)
            {
		output.append(line+"\n");				
            }
	} 
	catch (IOException e)
	{
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        catch (InterruptedException e) 
	{
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
		
	return output.toString();
    }    
}
