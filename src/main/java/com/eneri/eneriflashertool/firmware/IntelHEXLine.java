/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eneri.eneriflashertool.firmware;

import java.util.LinkedList;

/**
 *
 * @author Roberto Ascencio
 */
public class IntelHEXLine 
{
    private int byteCount;
    private int address;
    private int recordType;
    private byte[] data;
    private int checksum;
    private String rawLine;
    
    public IntelHEXLine(String rawLine)
    {
        this.rawLine = rawLine;
    }

    public int getByteCount()
    {
        return byteCount;
    }

    public int getAddress()
    {
        return address;
    }

    public int getRecordType() 
    {
        return recordType;
    }

    public byte[] getData() 
    {
        return data;
    }

    public String getChecksum() 
    {
        String checkSum;
        Convertions con = new Convertions();
        byte[] valores = con.hexStringToByteArray(rawLine.substring(1));
        int sumaArray = 0;
        for(int i=0; i<valores.length; i++)
        {
            //System.out.println(valores[i]);
            sumaArray = (sumaArray + valores[i]);
        }
        //System.out.println(String.format("%x",((sumaArray^0xFF)&0xFF)+1));
        return checkSum = String.format("%x",((sumaArray^0xFF)&0xFF)+1).toUpperCase();
    }
    
    public void parseLine() throws Exception
    {
        if(!this.rawLine.startsWith(":"))
        {
            throw new Exception("Doesn´t start with :");
        }
        String strData = this.rawLine.substring(1);
        
        char[] charArrayData = strData.toCharArray();
        LinkedList<Byte> listData = new LinkedList();
        
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < charArrayData.length; idx++)
        {
            char c = charArrayData[idx];
            if(HexUtils.isHexDigit(c))
            {
                sb.append(c);
            }
            switch(idx)
            {
                case 1:
                    byteCount = Integer.parseInt(sb.toString(),16);
                    sb.delete(0,sb.length());
                    break;
                case 5:
                    address = Integer.parseInt(sb.toString(), 16);
                    sb.delete(0, sb.length());
                    break;
                case 7:
                    recordType = Integer.parseInt(sb.toString(),16);
                    sb.delete(0, sb.length());
                    break;
            }
            if((idx>7) && (sb.length() == 2))
            {
                int byteData = Integer.parseInt(sb.toString(), 16);
                byteData &= 0xFF;
                listData.add(Byte.valueOf((byte)byteData));
                sb.delete(0, sb.length());
            }
        }
        checksum = (((Byte)listData.removeLast()).byteValue() & 0xFF);
        
        data = new byte[listData.size()];
        for(int idx=0; idx<data.length; idx++)
        {
            data[idx] = ((Byte)listData.get(idx)).byteValue();
        }
    }
}
