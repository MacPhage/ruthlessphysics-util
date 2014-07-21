//
//  Purify.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.util.stringmanipulation;

public class Purify
{
	public static String alphanumeric(String s)
	{
		return s.replaceAll("[^A-Za-z0-9]", "");
	}
}
