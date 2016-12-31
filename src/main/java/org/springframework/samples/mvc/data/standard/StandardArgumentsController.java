package org.springframework.samples.mvc.data.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class StandardArgumentsController {

	// ~~~~~~~~~~~~~~~~~~~~~~ request related ~~~~~~~~~~~~~~~~~~~~~~
	
	@RequestMapping(value="/data/standard/request", method=RequestMethod.GET)
	public @ResponseBody String standardRequestArgs(
			HttpServletRequest request, Principal user, Locale locale) {
		return "request = " + request + ", " +
				"userPrincipal = " + user + ", " +
				"requestLocale = " + locale;
	}
	@RequestMapping(value="/data/standard/webrequest", method=RequestMethod.GET)
	public @ResponseBody String standardWebRequestArgs(WebRequest request) {
		return "WEB_Request = " + request;
	}

	@RequestMapping(value="/data/standard/request/reader", method=RequestMethod.POST)
	public @ResponseBody String requestReader(Reader requestBodyReader) throws IOException {
		return "Read char request body = " + FileCopyUtils.copyToString(requestBodyReader);
	}

	@RequestMapping(value="/data/standard/request/is", method=RequestMethod.POST)
	public @ResponseBody String requestReader(InputStream requestBodyIs) throws IOException {
		return "Read binary request body = " + new String(FileCopyUtils.copyToByteArray(requestBodyIs));
	}
	
	// ~~~~~~~~~~~~~~~ response related ~~~~~~~~~~~~~~~~~~~~~~

	@RequestMapping("/data/standard/response")
	public @ResponseBody String response(HttpServletResponse response) {
		return "response = " + response;
	}

	@RequestMapping("/data/standard/response/writer")
	public void availableStandardResponseArguments(Writer responseWriter) throws IOException {
		responseWriter.write("Wrote char response using Writer");
	}
	
	@RequestMapping("/data/standard/response/os")
	public void availableStandardResponseArguments(OutputStream os) throws IOException {
		os.write("Wrote binary response using OutputStream".getBytes());
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~ HttpSession ~~~~~~~~~~~~~~~~~~~~~~

	@RequestMapping("/data/standard/session")
	public @ResponseBody String session(HttpSession session) {
		return "session=" + session;
	}

}
