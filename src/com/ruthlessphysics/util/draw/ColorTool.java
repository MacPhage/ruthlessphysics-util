package com.ruthlessphysics.util.draw;

import static org.lwjgl.opengl.GL11.glColor4f;

public class ColorTool
{
	public static float getFloat(int c)
	{
		return  (float)c / 256f;
	}
	public static float[] getFloats(java.awt.Color c)
	{
		float[] end = {getFloat(c.getRed()),getFloat(c.getGreen()),getFloat(c.getBlue()),getFloat(c.getAlpha())};
		return end;
	}
	public static float[] getFloats(org.newdawn.slick.Color c)
	{
		float[] end = {getFloat(c.getRed()),getFloat(c.getGreen()),getFloat(c.getBlue()),getFloat(c.getAlpha())};
		return end;
	}
	
	public static void glSwitchTo(java.awt.Color c)
	{
		float[] v = getFloats(c);
		glColor4f(v[0],v[1],v[2],v[3]);
	}
	public static void glSwitchTo(org.newdawn.slick.Color c)
	{
		float[] v = getFloats(c);
		glColor4f(v[0],v[1],v[2],v[3]);
	}
	
	public static org.newdawn.slick.Color awtToSlick(java.awt.Color c)
	{
		float[] colors = getFloats(c);
		return new org.newdawn.slick.Color(colors[0], colors[1], colors[2], colors[3]);
	}
	
	public static java.awt.Color slickToAwt(org.newdawn.slick.Color c)
	{
		float[] colors = getFloats(c);
		return new java.awt.Color(colors[0], colors[1], colors[2], colors[3]);
	}
	
	
}
