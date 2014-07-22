//
//  Manager.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.util.draw;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.ruthlessphysics.util.Debug;

public class Manager
{
	static int windowLength;
	static int windowHeight;
	static String windowTitle;
	static int defaultLength = 600;
	static int defaultHeight = 450;
	
	public static org.newdawn.slick.Graphics slick = new org.newdawn.slick.Graphics();
	
	public Manager(String t)
	{
		windowLength = defaultLength;
		windowHeight = defaultHeight;
		windowTitle = t;
	}
	public Manager(String t, boolean willInit)
	{
		windowLength = 400;
		windowHeight = 300;
		windowTitle = t;
		if(willInit)
		{
			init();
		}
	}
	public Manager(int l, int h, String t)
	{
		windowLength = l;
		windowHeight = h;
		windowTitle = t;
	}
	public Manager(int l, int h, String t, boolean willInit)
	{
		windowLength = l;
		windowHeight = h;
		windowTitle = t;
		if(willInit)
		{
			init();
		}
	}
	
	public static void setWindowLength(int newWindowLength)
	{
		windowLength = newWindowLength;
	}
	public static void setWindowHeight(int newWindowHeight)
	{
		windowHeight = newWindowHeight;
	}
	public static void setWindowTitle(String newWindowTitle)
	{
		windowTitle = newWindowTitle;
	}

	public static void init()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(windowLength,windowHeight));
			Display.setTitle(windowTitle);
			Display.create();
		}
		catch(LWJGLException e)
		{
			e.printStackTrace();
			Debug.displayError(e);
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(),-1,1);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(0,0,0,1);
		
		glDisable(GL_DEPTH_TEST);

	}
	
	public static void prep()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
	}
	
}
