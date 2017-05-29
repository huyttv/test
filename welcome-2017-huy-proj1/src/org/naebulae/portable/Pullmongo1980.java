package org.naebulae.portable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;

public class Pullmongo1980 extends Pullmongo1970 
{
	protected static void clean(String dname, String fname) throws Exception 
	{
		if(fname == null || fname.length() == 0) fname = "mongo-command-hieu.txt";
		
		String cmd = readText(fname, "[MONGO-CLEAN]");
		cmd = cmd.replace("<%DB_NAME%>", dname);
		
		exec(cmd);
	}

	protected static void deploy(String dname, String fname) throws Exception
	{
		if(fname == null || fname.length() == 0) fname = "mongo-command-hieu.txt";
		
		String cmd = readText(fname, "[MONGO-RESTORE]");
		
		cmd = cmd.replace("<%DB_NAME%>", dname);
		cmd = cmd.replace("<%RESTORE_FOLDER%>", getCachedFile(dname).getAbsolutePath());
		
		exec(cmd);
	}


	protected static String getCachedPrefix() 
	{
		return System.getProperty("user.home") + "/.cached/pullmongo/";
	}
	
	protected static File getCachedFile(String name) 
	{
		return new File(getCachedPrefix() + name);
	}	
	
	protected static void pull(String f) throws Exception 
	{
		InputStream sf = null;
		
		if(f.startsWith("http://") || f.startsWith("https://"))
		{
			URL u = new URL(f);
			sf = u.openStream();
		}
		
		else {
			sf = new FileInputStream(f);
		}
		
		pull(sf);
		
		sf.close();
	}

	private static void pull(InputStream sf) throws Exception
	{
		ZipInputStream rd = new ZipInputStream(sf);
		
		
		while(true)
		{
			ZipEntry ek = rd.getNextEntry();
			if(ek == null) break;
			if(ek.isDirectory()) continue;
			
			File fk = getCachedFile(ek.getName());
			System.out.println("creating " + fk.getAbsolutePath());
			
			fk.getParentFile().mkdirs();
			FileOutputStream vk = new FileOutputStream(fk);
			IOUtils.copy(rd, vk);
			vk.close();
		}		
		
		rd.close();
	}

}
