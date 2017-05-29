package org.naebulae.portable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class PulljarApp 
{
	public static void copyFile(URL sf, File tf) throws Exception 
	{
		tf.getParentFile().mkdirs();
		
		InputStream rd = sf.openStream();
		
		OutputStream out = new FileOutputStream(tf);
		IOUtils.copy(rd, out);
		out.close();

		rd.close();
	}
	
	public static void copyFile(URL sf, OutputStream out) throws Exception 
	{
		InputStream rd = sf.openStream();
		IOUtils.copy(rd, out);
		rd.close();
	}
	
	protected static URL getPulljarUrl(String uk) throws Exception 
	{
		if(uk.contains(".dropbox.com/s/") ) 
			if( uk.endsWith("&raw=1") == false) uk += "&raw=1";
		
		return new URL(uk);
	}


	protected static String getPulljarPrefix() {
		return System.getProperty("user.home") + "/.cached/pulljar/";
	}
	
	protected static File getPulljarFile(String name) 
	{
		return new File(getPulljarPrefix() + name);
	}


}
