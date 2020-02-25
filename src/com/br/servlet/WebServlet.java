package com.br.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.routing.Router;

public class WebServlet extends HttpServlet  {
    private Router router;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.mapping(req, resp);
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
    
    
}
