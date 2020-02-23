package com.br.routing.models;

import com.br.routing.interfaces.Execute;

public class Route {
    private Execute executer;
    
    public Execute getExecuter() {
        return executer;
    }
    public void setExecuter(Execute executer) {
        this.executer = executer;
    }    
    
    
}
