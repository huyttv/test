package apps.firstapp.services;

import java.lang.reflect.Method;

public class Res {

	public static String name(Method name) 
	{
		if(name==null) return null;
		return name.getName();
	}

	public static String name(Class<?> name) 
	{
		if(name==null) return null;
		return name.getSimpleName();
	}

}
