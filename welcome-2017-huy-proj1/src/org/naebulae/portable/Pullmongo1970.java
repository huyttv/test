package org.naebulae.portable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.naebulae.util.String2;

public class Pullmongo1970 
{
	protected static void exec(String cmd) throws Exception
	{
		System.out.println("Executing + [" + cmd + "]");
		ProcessBuilder b = new ProcessBuilder(cmd.split("\\s+"));
		b.inheritIO();
		b.start();		
	}

	protected static String readText(String seg, String head) throws Exception 
	{
		File f = new File(Pullmongo1970.class.getResource(seg).getFile());
		System.out.println("Reading stream " + seg + " | " + f );
		
		InputStream rd = new FileInputStream(f);
		List<String> lines = IOUtils.readLines(rd);
		rd.close();
		
		System.out.println(lines);
		
		List<String> res = new ArrayList<>();
		
		int st = 0;
		for(String lk: lines) 
		{
			if(st==0) {  
				if(lk.startsWith(head) ) st++; 
			}
			else { 
				if(lk.startsWith("#")) continue;
				else if(lk.startsWith("[")) break;
				else res.add(lk); 
			}
		}
		
		return String2.joinList("\r\n", res);
	}
	

}
