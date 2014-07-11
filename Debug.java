//
//  Debug.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.util;

import javax.swing.*;

import java.io.*;
import java.util.*;

/*

EXCEPTION TEMPLATE

try
{
  //code
}
catch (Exception e)
{
  e.printStackTrace();
  if(Debug.displayDebug())
  {
    JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
  }
}

*/

public class Debug
{
	static String title = com.ruthlessphysics.obskewer.Obskewer.projectName;
  public static void println(String text)
  {
    if(shouldLog())
    {
      System.out.println("[Debug.java]: "+text);
    }
  }
  public static void print(String text)
  {
    if(shouldLog())
    {
      System.out.print(text);
    }
  }
  public static void displayError(Exception e)
  {
    if(displayDebug())
    {
      JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
    }
  }
  public static void setDefault()
  {
    Properties config = new Properties();
    OutputStream output = null;
    try
    {
      output = new FileOutputStream(title+"-debug.properties");
      config.setProperty("displayDebug", "yes");
      config.setProperty("alertAlwaysAs", "pass");
      config.setProperty("defaultCommand","help");
      config.setProperty("shouldLog","yes");
      config.setProperty("seperator",Character.toString('\u1337'));
      config.store(output, null);
    }
    catch (IOException io)
    {
      io.printStackTrace();
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
  public static boolean displayDebug()
  {
    Properties prop = new Properties();
	  InputStream input = null;
	  try
    {
  		input = new FileInputStream("pcalculator-debug.properties");
  		prop.load(input);
  		String should = prop.getProperty("displayDebug");
      if(should.equals("yes"))
      {
        return true;
      }
      else
      {
        return false;
      }
	  }
    catch (IOException ex)
    {
		ex.printStackTrace();
    return false;
	  }
    finally
    {
  		if (input != null)
      {
  			try
        {
  				input.close();
  			}
        catch (IOException e)
        {
  				e.printStackTrace();
          return false;
  			}
  		}
	  }
  }
  public static String alertAlwaysAs()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      String type = prop.getProperty("alertAlwaysAs");
      return type;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return "pass";
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return "pass";
        }
      }
    }
  }
  public static String defaultCommand()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      String type = prop.getProperty("defaultCommand");
      return type;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return "help";
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return "help";
        }
      }
    }
  }
  public static boolean debugFileExists()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      return true;
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return false;
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return false;
        }
      }
    }
  }
  public static boolean shouldLog()
  {
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-debug.properties");
      prop.load(input);
      String should = prop.getProperty("shouldLog");
      if(should.equals("yes"))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (IOException ex)
    {
    ex.printStackTrace();
    return false;
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return false;
        }
      }
    }
  }
  public static void alert(String message, String type) //Just like JavaScript :P
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
  public static void alert(String message)
  {
	  alert(message,"plain");
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
