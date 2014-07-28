package com.ruthlessphysics.util;

import javax.swing.JOptionPane;

public class Debug
{
	public static boolean alertDebugErrors(Config config)
	{
		try
		{
			return Boolean.valueOf(config.get("AlertDebugErrors").toString());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public static boolean logDebugErrors(Config config)
	{
		try
		{
			return Boolean.valueOf(config.get("LogDebugErrors").toString());
		}
		catch(Exception e)
		{
			return true;
		}
	}
	
	public static void displayError(Exception e)
	{
		JOptionPane.showMessageDialog(null,e.getStackTrace(),"Error",JOptionPane.ERROR_MESSAGE);
	}
	public static void logError(Exception e)
	{
		e.printStackTrace();
	}
	public static void alert(String message, String title, String type) //Just like JavaScript :P
	{
		type = type.toLowerCase();
		if(type.equals("error"))
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE);
		}
		else if(type.equals("information"))
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
		}
		else if(type.equals("warning"))
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.WARNING_MESSAGE);
		}
		else if(type.equals("question"))
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
		}
		else if(type.equals("plain"))
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,message,title,JOptionPane.PLAIN_MESSAGE);
			System.out.println("Attempted to alert() with invalid type: \'"+type+"\', went with plain instead.");
		}
	}
	public static void alert(String message, String type)
	{
		alert(message,"Alert",type);
	}
	public static void alert(String message)
	{
		alert(message,"Alert","plain");
	}
	public static void message(String m,String output) //Just like JavaScript :P
	{
		JOptionPane.showInputDialog(null,m,output);
	}
	public static void message(String output)
	{
		message("Important",output);
	}
}
