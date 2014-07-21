//
//  ExtraMath.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.util;

public class ExtraMath
{
	public static double average(double[] d)
	{
		double result = 0;
		for(int i = 0; i < d.length; i++)
		{
			result += d[i];
		}
		result /= (double)d.length;
		return result;
	}
	public static float average(float[] f)
	{
		float result = 0;
		for(int i = 0; i < f.length; i++)
		{
			result += f[i];
		}
		result /= (double)f.length;
		return result;
	}
	public static int average(int[] n)
	{
		int result = 0;
		for(int i = 0; i < n.length; i++)
		{
			result += n[i];
		}
		result /= (int)n.length;
		return result;
	}
	public static long average(long[] l)
	{
		long result = 0;
		for(int i = 0; i < l.length; i++)
		{
			result += l[i];
		}
		result /= (long)l.length;
		return result;
	}
}
