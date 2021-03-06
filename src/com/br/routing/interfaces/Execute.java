package com.br.routing.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Execute {
    public void routeExecuter(HttpServletRequest req, HttpServletResponse res);

}
