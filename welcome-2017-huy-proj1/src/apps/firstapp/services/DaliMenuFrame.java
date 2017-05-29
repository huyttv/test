package apps.firstapp.services;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class DaliMenuFrame 
{
	protected DaliMenuNode root = new DaliMenuNode();

	public DaliMenuFrame()
	{
	}

	public Image imageFromResource(Class<?> cl, String name) 
	{
		try {
			InputStream in = cl.getResourceAsStream(name);
			BufferedImage img = ImageIO.read(in);
			in.close();
			return img;
		}
		
		catch(Exception xp) { return null; }
	}

	
	public<T1> T1 menuGet(String path, T1 dv) 
	{
		DaliMenuNode cur = root;
		
		for(String pk: path.split("\\/+")) {
			cur = cur.get(pk);
			if(cur == null) break;
		}
		
		return dv;
	}
	
		
	public<T1 extends DaliRequestProcessor> DaliMenuNode menuPut(String path, Class<T1> src, String act)  
	{
		DaliMenuNode cur = root;
		
		for(String pk: path.split("\\/+")) 
		{
			cur = cur.findOrInsert(pk);
		}
						
		cur.targetClass = src;
		
		try { cur.targetAction = src.getMethod(act + "Action"); }
		catch(Exception xp) { xp.printStackTrace(); }
		
		return cur;
	}

	public void menuDump() 
	{
		dump(root, 0);
	}

	private void dump(DaliMenuNode p, int level) 
	{
		for(int k=0; k<level; k++) System.out.print("-- ");
		System.out.println(p);
		
		for(String nk: p.keySet() ) dump(p.get(nk), level+1);
	}

	public JMenu newJMenu(String name, int key) 
	{
		JMenu res = new JMenu(name);
		res.setMnemonic(key);
		return res;
	}
	
	public JMenuItem newJMenuItem(String name, int alt, int ctrl) 
	{
		return newJMenuItem(name, alt, ctrl, ActionEvent.CTRL_MASK);
	}
	
	public JMenuItem newJMenuItem(String name, int alt, int ctrl, int mask) 
	{
		JMenuItem res = new JMenuItem(name);		
		res.setMnemonic(alt);
		res.setAccelerator(KeyStroke.getKeyStroke(ctrl, mask));		
		return res;
	}	

}
