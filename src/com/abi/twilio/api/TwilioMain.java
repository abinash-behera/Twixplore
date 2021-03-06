package com.abi.twilio.api;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.verbs.Message;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class TwilioMain extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// service() responds to both GET and POST requests.
	// You can also use doGet() or doPost()
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TwiMLResponse twiml = new TwiMLResponse();
		Message message = new Message("Hello, Mobile Monkey");
		try {
			twiml.append(message);
		} catch (TwiMLException e) {
			e.printStackTrace();
		}

		response.setContentType("application/xml");
		response.getWriter().print(twiml.toXML());
	}
}