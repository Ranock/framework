package com.br.injection;

import java.util.HashMap;
import java.util.Map;

import com.br.mock.controller.HomeController;
import com.br.mock.service.HomeService;
import com.br.routing.Router;
import com.br.routing.models.RouterPaths;
import com.br.utils.interfaces.Initializer;


public class Injector implements Initializer {
    
    private Map<String, Object> dependencies;
    private  static Injector injector;
    

    public static Injector getInjectable() {
        if (injector == null) {
            synchronized (Injector.class) {
                injector = new Injector();                
            }
        }
        return injector;
        
    }
    private Injector() {
        super(); 
        init();
    }



    public Object getDependency(String name) {
        Object dependency =  dependencies.get(name);
        if (dependency == null) {
            throw new RuntimeException("Dependency : "+ name + " does not exist");
            }
        return dependency;
        }
    @Override
    public void init() {
          dependencies = new HashMap();
          HomeService homeService = new HomeService();
          HomeController homeController = new HomeController(homeService);
          dependencies.put(HomeService.class.getName(), homeService);
          dependencies.put(HomeController.class.getName(), homeController);
          
          Router routerInitializer = new Router(homeController);
          
          dependencies.put(Router.class.getName(), routerInitializer);

          
    }
    
    
}
