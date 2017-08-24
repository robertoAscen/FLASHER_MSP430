/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.ui;

import java.awt.EventQueue;

/**
 *
 * @author Roberto Ascencio
 */
public class Launcher 
{
	public static JFrameMain jFrameMain = new JFrameMain(); 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				Launcher.getFrameMain().setVisible(true);
				Launcher.getFrameMain().setLocationRelativeTo(null);
			}
		});
	}

	public static JFrameMain getFrameMain()
	{
		return jFrameMain;
	}
}
