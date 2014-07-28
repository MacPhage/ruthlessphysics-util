package com.ruthlessphysics.util;

import org.kohsuke.github.*;

public class Version
{
	private String authorName; //The author's name on GitHub
	private String projectName; //The project's name on GitHub
	private String localVersion; //The local version of the project, as in the GitHub tag
	private boolean inDevelopment = true;
	
	public static Config config = new Config("Version");
	
	public static void main(String args[])
	{
		Version v = new Version("MacPhage","pCalculator","v1.0.0");
		String a = v.getCurrent();
		System.out.println("a = "+a);
		System.exit(0);
	}
	
	public Version(String a, String p, String v)
	{
		authorName = a;
		projectName = p;
		localVersion = v;
		this.checkForUpdate();
	}
	
	public String getAuthorName()
	{
		return authorName;
	}
	public String getProjectName()
	{
		return projectName;
	}
	public String getLocalVersion()
	{
		return localVersion;
	}
	
	public String getCurrent()
	{
		//Use GitHub API to get JSON of project releases, compare to localVersion
		String tag = "undefined";
		try
		{
			GitHub github = GitHub.connectAnonymously();
			System.out.println("Connected to GitHub anon style...");
			GHRepository repo = github.getRepository(authorName+"/"+projectName);
			System.out.println("Successfully retrieved repo \'"+authorName+"/"+projectName+"\'...");
			tag = repo.listReleases().asList().get(0).getTagName();
			System.out.println("Successfully retrieved release list...");
			System.out.println("Assuming current release has index of 0, current release tag is: "+tag);
		}
		catch(Exception e)
		{
			if(Debug.alertDebugErrors(config))
			{
				Debug.displayError(e);
			}
		}
		
		return tag;
	}
	
	public boolean isCurrent()
	{
		System.out.println("Checking if local version is the current version...");
		
		String currentVersion =  this.getCurrent();
		currentVersion = currentVersion.substring(1);
		String[] c = currentVersion.split(".");
		Build current = new Build(c);
		Build local = new Build(localVersion.split("."));
		
		if(inDevelopment)
		{
			System.out.println("Software is still under development. Definitely is current.");
			return true;
		}
		else if(current.major > local.major)
		{
			System.out.println("Local version is behind by "+(current.major-local.major)+" major versions.");
			return false;
		}
		else if(current.minor > local.minor)
		{
			System.out.println("Local version is behind by "+(current.minor-local.minor)+" minor versions.");
			return false;
		}
		else if(current.patch > local.patch)
		{
			System.out.println("Local version is behind by "+(current.patch-local.patch)+" patches.");
			return false;
		}
		else if(current.build > local.build)
		{
			System.out.println("Local version is behind by "+(current.build-local.build)+" builds.");
			return false;
		}
		else
		{
			System.out.println("Local version is behind by 0 versions.");
			return true;
		}
	}
	
	public void checkForUpdate()
	{
		System.out.println("checkForUpdate() called...");
		if(!this.isCurrent())
		{
			Debug.alert("You\'re version of "+projectName+" is out of date.\n"+
			"The newest version can be found on http://github.com/"+authorName+"/"+projectName);
		}
		else
		{
			System.out.println("**Software is up to date!**å");
		}
	}
	
}
class Build
{
	int major;
	int minor;
	int patch;
	int build;
	
	Build(String[] ver)
	{
		try
		{
			major = Integer.parseInt(ver[0]);
			minor = Integer.parseInt(ver[1]);
			patch = Integer.parseInt(ver[2]);
			build = Integer.parseInt(ver[3]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(Debug.alertDebugErrors(Version.config))
			{
				Debug.displayError(e);
			}
		}
	}
}
