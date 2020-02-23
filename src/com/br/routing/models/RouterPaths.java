package com.br.routing.models;

import java.util.HashMap;
import java.util.Map;

import com.br.routing.enums.HttpMethods;
import com.br.routing.interfaces.Execute;

public class RouterPaths {

    private Map<String, Map<HttpMethods, Route>> routers;
    
    
    public RouterPaths(int size) {
        super();
        //TODO create with size of qtd mappings
        this.routers = new HashMap<String, Map<HttpMethods,Route>>();
    }


    public void addRoute(String path, HttpMethods method, Execute executer) {
        Route r = new Route();
        r.setExecuter(executer);
        Map<HttpMethods, Route> methods = getMethods(path, method);
        methods.put(method, r);
        routers.put(path, methods);
    }
    
    public boolean accepts(String path, HttpMethods method) {
        return (routers.containsKey(path) && routers.get(path).containsKey(method));        
    }
    
    public Route retrieve(String path, HttpMethods method) {
        return routers.get(path).get(method);
        
    }
    public Map<HttpMethods, Route> getMethods(String path, HttpMethods method){
        if (routers == null) 
            throw new RuntimeException("Routers is null this should not be possible to happen");
        
        if(routers.get(path) == null)  
            return new HashMap<HttpMethods, Route>(HttpMethods.values().length);
        
        if(routers.get(path).containsKey(method))
            throw new RuntimeException("This route: "+path+", Method : "+method.name()+" has been registered before");

        return routers.get(path);
        
    }
}
