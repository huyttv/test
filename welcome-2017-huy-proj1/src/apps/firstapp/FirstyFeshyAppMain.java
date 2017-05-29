package apps.firstapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apps.firstapp.m1_api.Api1_Product;
import apps.firstapp.m1_api.Api2_Order;
import apps.firstapp.m1_api.Api3_Post;
import apps.firstapp.m1_api.Api4_Outlet;
import apps.firstapp.m1_api.Api5_Login;
import apps.firstapp.m1_api.Api6_User;
import apps.firstapp.services.DaliMenuFrame;
import apps.firstapp.services.DaliRequestArgs;
import apps.firstapp.services.DaliRequestParser;

public class FirstyFeshyAppMain extends DaliMenuFrame 
{
	private static FirstyFreshyBaseModule __default = new FirstyFreshyBaseModule();
	private static FirstyFeshyAppMain __frame = new FirstyFeshyAppMain();
	
	public FirstyFeshyAppMain() 
	{
		super.menuPut("api/product/index", Api1_Product.class, "index");
		
		super.menuPut("api/order/view", Api2_Order.class, "index");	
		super.menuPut("api/order/add", Api2_Order.class, "add");
		super.menuPut("api/order/remove", Api2_Order.class, "remove");
		super.menuPut("api/order/send", Api2_Order.class, "send");
		super.menuPut("api/order/history", Api2_Order.class, "history");	
		
		super.menuPut("api/post/index", Api3_Post.class, "index");		
		super.menuPut("api/outlet/index", Api4_Outlet.class, "index");
		
		super.menuPut("api/login/email", Api5_Login.class, "email");
		super.menuPut("api/login/register", Api5_Login.class, "register");
		super.menuPut("api/login/forgot", Api5_Login.class, "forgot");
		
		super.menuPut("api/user/index", Api6_User.class, "index");
		super.menuPut("api/user/logout", Api6_User.class, "logout");
		super.menuPut("api/user/pwd", Api6_User.class, "pwd");
	}
	
	public static void main(String[] args) 
	{
		__frame.menuDump();		
	}
	
	
	public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DaliRequestParser p = DaliRequestParser.parseRequest(request);
		System.out.println("-- mapping from: " + p.requestUrl);
		System.out.println("-- -- internet-url: " + p.internetUrl);
		System.out.println("-- -- operating-url: " + p.operatingUrl);
		
		FirstyFreshyBaseModule ctrl = __frame.menuGet(p.operatingUrl, __default);
		System.out.println("-- mapping to: " + ctrl.getClass().getName());
		
		DaliRequestArgs a = new DaliRequestArgs();
		a.request = request;
		a.response = response;
		
		ctrl.processRequest(a);		
	}
	


}
