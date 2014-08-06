//
//  StringTools.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://github.com/MacPhage
//

package com.ruthlessphysics.util;

import java.util.ArrayList;
import java.util.List;

public class StringTools 
{
	public static final int WITH_SPACES = 0;
	public static final int NO_SPACES = 1;

	public static String fuse(String[] s)
	{
		return fuse(s,NO_SPACES);
	}
	public static String fuse(String[] s, int mode)
	{
		String result = "";
		if(mode == WITH_SPACES)
		{
			for(int i = 0; i < s.length; i++)
			{
				result += s[i]+" ";
			}
		}
		else if(mode == NO_SPACES)
		{
			for(int i = 0; i < s.length; i++)
			{
				result += s[i];
			}
		}

		return result;
	}
	public static Object[] cutout(Object[] in, int from, int to) throws Exception
	{
		List<Object> out = new ArrayList<Object>();

		if(to > in.length)
		{
			throw new Exception("The given index ("+to+") was larger than the size of the Object array");
		}

		try
		{
			for(int i = from; i < to; i++)
			{
				out.add(in[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return out.toArray();
	}
}

class Purify
{
	public static String alphanumeric(String s)
	{
		return s.replaceAll("[^A-Za-z0-9]", "");
	}
}