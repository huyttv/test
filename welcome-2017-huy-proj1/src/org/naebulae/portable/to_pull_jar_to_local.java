package org.naebulae.portable;

import java.io.File;
import java.net.URL;


public class to_pull_jar_to_local extends PulljarApp 
{
	public static void main(String[] args) throws Exception
	{
		pull("https://www.dropbox.com/s/bmm5dgcqj7sx81l/naebulae-2017m04d01-minimal.jar?dl=0", "naebulae-2017m04d01-minimal.jar");
		System.out.println("PULLED OVER: " + getPulljarFile(""));
	}

	private static void pull(String s1, String s2) throws Exception
	{
		URL sf = getPulljarUrl(s1);
		File tf = getPulljarFile(s2);
//		if(tf.exists()) return;
		
		System.out.println("Pulling " + sf);
		copyFile(sf, tf);		
	}

	
}
