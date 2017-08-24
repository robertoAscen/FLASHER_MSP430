/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.firmware;

/**
 *
 * @author Roberto Ascencio
 */
public class Convertions 
{
    private String strSerialNumberFabric;
    
    private String strValueHex;
    private StringBuilder sb;
    
    public String getHexSNF(String strSNF)
    {
    	sb = new StringBuilder();
        for(int i = 0; i<strSNF.length(); i++)
        {
            int valueStr = Integer.parseInt(strSNF.substring(i, i+1));
            if(valueStr == 0)
            {
                strValueHex = "30";
                sb.append(strValueHex);
            }
            if(valueStr == 1)
            {
                strValueHex = "31";
                sb.append(strValueHex);
            }
            if(valueStr == 2)
            {
                strValueHex = "32";
                sb.append(strValueHex);
            }
            if(valueStr == 3)
            {
                strValueHex = "33";
                sb.append(strValueHex);
            }
            if(valueStr == 4)
            {
                strValueHex = "34";
                sb.append(strValueHex);
            }
            if(valueStr == 5)
            {
                strValueHex = "35";
                sb.append(strValueHex);
            }
            if(valueStr == 6)
            {
                strValueHex = "36";
                sb.append(strValueHex);
            }
            if(valueStr == 7)
            {
                strValueHex = "37";
                sb.append(strValueHex);
            }
            if(valueStr == 8)
            {
                strValueHex = "38";
                sb.append(strValueHex);
            }
            if(valueStr == 9)
            {
                strValueHex = "39";
                sb.append(strValueHex);
            }            
        }
        return sb.toString();
    }
    
    public static byte[] hexStringToByteArray(String s)
    {
        byte[] b = new byte[s.length()/2];
        for(int i = 0; i<b.length; i++)
        {
            int index = i*2;
            int v = Integer.parseInt(s.substring(index, index+2),16);
            b[i]=((byte)v);
        }
        return b;
    }

    public String getStrSerialNumberFabric()
    {
        return strSerialNumberFabric;
    }

    public void setStrSerialNumberFabric(String strSerialNumberFabric)
    {
        this.strSerialNumberFabric = strSerialNumberFabric;
    }    
}
