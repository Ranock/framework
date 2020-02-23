package com.br.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import com.br.injection.Injector;
import com.br.routing.Router;

@WebListener
public class WebListenerImpl implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    ServletContextListener.super.contextInitialized(sce);
    ServletContext sc = sce.getServletContext();
    WebServlet s = new WebServlet();
    Injector i = Injector.getInjectable();
    Router r = (Router) i.getDependency("com.br.routing.Router");
    s.setRouter(r);
    System.out.println("WebServer is online [ "+sce.getServletContext().getServerInfo()+" ] ");
    ServletRegistration sr = sc.addServlet("WebServlet", s);
      sr.addMapping("/"); 
    }
}
