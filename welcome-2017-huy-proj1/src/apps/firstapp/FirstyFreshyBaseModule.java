package apps.firstapp;

import org.naebulae.writers.HtmlWriter;

import apps.firstapp.services.DaliRequestArgs;
import apps.firstapp.services.DaliRequestProcessor;

public class FirstyFreshyBaseModule implements DaliRequestProcessor {

	protected HtmlWriter out;

	@Override
	public void processRequest(DaliRequestArgs a) throws Exception
	{
		out = new HtmlWriter(a.response.getWriter());
		out.h1("This is test " + System.currentTimeMillis() + " / " + this.getClass().getName());
	}

}
