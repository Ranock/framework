package com.br.routing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.mock.controller.HomeController;
import com.br.routing.enums.HttpMethods;
import com.br.routing.models.ResponseEntity;
import com.br.routing.models.RouterPaths;
import com.br.utils.interfaces.Initializer;

public class Router implements Initializer {
    
    private HomeController homeController;
    
    public Router(HomeController homeController) {
        super();
        //TODO define at runtime
        this.routes = new RouterPaths(1);
        this.homeController = homeController;
        init();
    }

    private RouterPaths routes;

    @Override
    public void init() {
        routes.addRoute("/", HttpMethods.GET, (req, res) -> {
                    ResponseEntity<String> s = homeController.retrieveOk();
                    PrintWriter bufferedWriter;
                    try {
                        bufferedWriter = res.getWriter();
                        bufferedWriter.println(s.getBody());
                        res.setStatus(200);
                    } catch (IOException e) {
                        res.setStatus(500);
                        e.printStackTrace();
                    }
        });
    }
    
    public void maping(HttpServletRequest req, HttpServletResponse res) {
        String context = req.getContextPath();
        String path = null;
        if (context.trim().isEmpty())
            path = req.getRequestURI();
        else
            path = req.getRequestURI().replace(req.getContextPath(), "");
        
        HttpMethods method = HttpMethods.fromString(req.getMethod());

        if(this.routes.accepts(path, method)) {
            this.routes.retrieve(path, method).getExecuter().routeExecuter(req, res); 
        } else {
            res.setStatus(404);
        }
    }
}
