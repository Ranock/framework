package com.br.routing.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpRequest extends HttpServletRequestWrapper{

    public HttpRequest(HttpServletRequest request) {
        super(request);
    }

}
