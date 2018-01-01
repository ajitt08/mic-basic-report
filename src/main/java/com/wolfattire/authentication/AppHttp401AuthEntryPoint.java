package com.wolfattire.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AppHttp401AuthEntryPoint implements AuthenticationEntryPoint{
	
	private boolean isAuthorizedRequest(String requestServletPath) {
        return (!requestServletPath.contains("public") && !requestServletPath.contains("favicon"));
    }

	
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException arg2)
			throws IOException, ServletException {
		if(isAuthorizedRequest(httpServletRequest.getServletPath()) ) {
            if (httpServletRequest.getServletPath().contains("login")) {
                httpServletResponse.sendRedirect("/");
            }
            else {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
            }
        }
		
	}

}
