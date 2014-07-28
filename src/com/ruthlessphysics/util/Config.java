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

import com.ruthlessphysics.util.Debug;

import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Config
{
	public String title = "default";
	public String classPrefix = "default";
	public String prefix = "";

	public JSONObject json = new JSONObject();

	public Config(String title)
	{
		this.title =  title;
		this.getConfig();
	}

	public void setDefault()
	{
		json.put("LogDebugErrors", "true");
		json.put("AlertDebugErrors", "false");
		json.put("DefaultCommand","help");
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setClassPrefix(String classPrefix)
	{
		this.classPrefix = classPrefix;
	}

	public void writeConfig()
	{
		try
		{
			PrintWriter out = new PrintWriter(this.title+"-config.json");
			out.write(json.toJSONString());
			out.close();
		}
		catch(Exception e)
		{
			Debug.logError(e);
			//Debug.displayError(e);
		}
	}
	public void getConfig()
	{
		try 
		{
			this.json = (JSONObject)new JSONParser().parse(IOTool.readFile(this.title+"-config.json"));
		} 
		catch (Exception e) 
		{
			Debug.logError(e);
			//Debug.displayError(e);
			this.setDefault();
		}
	}
	
	public JSONObject getJSONObject()
	{
		return json;
	}

	public String getFileName()
	{
		return this.title+"-config.json";
	}
	public String get(Object attribute)
	{
		return (String) this.json.get(attribute);
	}
	public void put(Object key, Object attribute)
	{
		this.json.put(key, attribute);
	}

	


}
