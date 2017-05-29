package apps.firstapp.services;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DaliMenuNode 
{
	public Class<?> targetClass;
	@Override
	public String toString() {
		return "DaliMenuNode [targetClass=" + targetClass + ", targetAction=" + targetAction + ", nodes=" + nodes + "]";
	}

	public Method targetAction;
	
	protected Map<String, DaliMenuNode> nodes = new LinkedHashMap<String, DaliMenuNode>();

	public DaliMenuNode findOrInsert(String pk) 
	{
		DaliMenuNode res = nodes.get(pk);
		if(res == null) nodes.put(pk, res = new DaliMenuNode());
		return res;
	}

	public Set<String> keySet() 
	{
		return nodes.keySet();
	}
	
	public DaliMenuNode get(String nk)
	{
		return nodes.get(nk);
	}

}
