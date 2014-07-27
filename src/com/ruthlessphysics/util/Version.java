package com.ruthlessphysics.util;
import org.eclipse.egit.github.core.client.GitHubClient;
public class Version
{
	private String authorName; //The author's name on GitHub
	private String projectName; //The project's name on GitHub
	private String localVersion; //The local version of the project, as in the GitHub tag
	
	public Version(String a, String p, String v)
	{
		authorName = a;
		projectName = p;
		localVersion = v;
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
		GitHubClient.createClient("http://github.com/"+authorName+"/"+projectName);
		
		
		return projectName;
	}
	
}
