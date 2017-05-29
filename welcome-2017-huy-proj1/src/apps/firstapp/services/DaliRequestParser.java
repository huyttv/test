package apps.firstapp.services;

import javax.servlet.http.HttpServletRequest;

public class DaliRequestParser 
{
	public String requestUrl;
	public String internetUrl;
	public String operatingUrl;

	public static DaliRequestParser parseRequest(HttpServletRequest request) 
	{
		return parseRequest(request.getRequestURL().toString());
	}	
	
	public static DaliRequestParser parseRequest(String u) 
	{
		DaliRequestParser res = new DaliRequestParser();
		res.requestUrl = u;
		res.internetUrl = readInternetUrl(u);
		res.operatingUrl = readOperatingUrl(u, res.internetUrl.length());

		return res;
	}

	protected static String readOperatingUrl(String s, int n) 
	{
		if(s.length()<=n) return "";
		else return s.substring(n+1);
	}

	protected static String readInternetUrl(String s) 
	{
		int x = s.indexOf('/', 8);
		if(x<0) return s;
		
		x = s.indexOf('/', x+1);
		if(x<0) return s;
		
		return s.substring(0, x);
	}

	
}
