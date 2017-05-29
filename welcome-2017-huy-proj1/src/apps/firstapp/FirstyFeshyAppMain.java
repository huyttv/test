package apps.firstapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apps.firstapp.services.DaliRequestArgs;

public class FirstyFeshyAppMain 
{
	private static FirstyFreshyBaseModule __default = new FirstyFreshyBaseModule();
	
	public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		FirstyFreshyBaseModule ctrl = __default;
		System.out.println("-- mapping to: " + ctrl.getClass().getName());
		
		DaliRequestArgs a = new DaliRequestArgs();
		a.request = request;
		a.response = response;
		
		ctrl.processRequest(a);		
	}
	
	
}
