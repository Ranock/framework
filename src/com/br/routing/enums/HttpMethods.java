package com.br.routing.enums;

public enum HttpMethods {
    GET, POST, OPTION, PUT, DELETE, PATH;
    
    
    public static HttpMethods fromString(String s) {
        for (HttpMethods m : HttpMethods.values()) {
            if (m.name().equals(s)) {
                return m;
            }
        }
        throw new RuntimeException("Method not allowed");
    }
}
