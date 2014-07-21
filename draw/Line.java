//
//  Line.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.util.draw;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.util.Color;

public class Line
{
	public static float x; //X coordinate
	public static float y; //Y coordinate
	public static float l; //Length
	public static float t; //Thickness
	public static float rot; //Rotation
	public static Color c; //Color
	public static float alpha; //Alpha transparency
	
	public Line()
	{
		x = 100;
		y = 100;
		l = 100;
		t = 5;
		rot = 45;
		c = new Color(255,255,255);
		alpha = (float)c.getAlpha();
	}
	public Line(float nextX, float nextY, float nextW, float nextH)
	{
		x = nextX;
		y = nextY;
		l = nextW;
		t = nextH;
		c = new Color(255,255,255);
		alpha = (float)c.getAlpha();
	}
	public Line(float nextX, float nextY, float nextW, float nextH, float nextRot)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = nextRot;
		c =  new Color(255,255,255);
		alpha = (float)c.getAlpha();
	}
	public Line(float nextX, float nextY, float nextW, float nextH, Color inC)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = 0;
		c = inC;
		alpha = (float)c.getAlpha();
	}
	public Line(float nextX, float nextY, float nextW, float nextH, float nextRot, Color inC)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = nextRot;
		c = inC;
		alpha = (float)c.getAlpha();
	}
	
	public Line(boolean drawNow)
	{
		x = 100;
		y = 100;
		w = 100;
		h = 100;
		rot = 45;
		c = new Color(255,255,255);
		alpha = (float)c.getAlpha();
		if(drawNow)
		{
			draw();
		}
	}
	public Line(float nextX, float nextY, float nextW, float nextH, boolean drawNow)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		c = new Color(255,255,255);
		alpha = (float)c.getAlpha();
		if(drawNow)
		{
			draw();
		}
	}
	public Line(float nextX, float nextY, float nextW, float nextH, float nextRot, boolean drawNow)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = nextRot;
		c =  new Color(255,255,255);
		alpha = (float)c.getAlpha();
		if(drawNow)
		{
			draw();
		}
	}
	public Line(float nextX, float nextY, float nextW, float nextH, Color inC, boolean drawNow)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = 0;
		c = inC;
		alpha = (float)c.getAlpha();
		if(drawNow)
		{
			draw();
		}
	}
	public Line(float nextX, float nextY, float nextW, float nextH, float nextRot, Color inC, boolean drawNow)
	{
		x = nextX;
		y = nextY;
		w = nextW;
		h = nextH;
		rot = nextRot;
		c = inC;
		alpha = (float)c.getAlpha();
		if(drawNow)
		{
			draw();
		}
	}
	
	
	public static void setX(float next)
	{
		x = next;
	}
	public static float getX()
	{
		return x;
	}
	public static void setY(float next)
	{
		y = next;
	}
	public static float getY()
	{
		return y;
	}
	public static void setW(float next)
	{
		w = next;
	}
	public static float getW()
	{
		return w;
	}
	public static void setH(float next)
	{
		h = next;
	}
	public static float getH()
	{
		return h;
	}
	public static void setRot(float newRot)
	{
		rot = newRot;
	}
	public static float getRot()
	{
		return rot;
	}
	public static void setColor(Color newC)
	{
		c = newC;
	}
	public static Color getColor()
	{
		return c;
	}
	public static void setAlpha(float newAlpha)
	{
		alpha = newAlpha;
	}
	public static float getAlpha()
	{
		return alpha;
	}
	
	
	public static float getArea()
	{
		return w*h;
	}
	public static float getPerimeter()
	{
		return (2F*w)+(2F*h);
	}
	
	public static float perc(int a) //Color percentage
	{
		return a / 255f;
	}
	
	public static void draw()
	{
		glColor4f(perc(c.getRed()),perc(c.getBlue()),perc(c.getGreen()),alpha);
		glPushMatrix();
		{
			glTranslatef(x,y,0);
			glRotatef(rot,0,0,1);

			glBegin(GL_QUADS);
			{
				glVertex2f(0,0);
				glVertex2f(0,h);
				glVertex2f(w,h);
				glVertex2f(w,0);
			}
			glEnd();
		}
		glPopMatrix();
	}
}
