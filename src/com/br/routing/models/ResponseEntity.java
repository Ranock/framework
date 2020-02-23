package com.br.routing.models;

public class ResponseEntity<T> {
    
    private int status;
    private T body;
    
    
    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public T getBody() {
        return body;
    }


    public void setBody(T body) {
        this.body = body;
    }


    public static ResponseEntityBuilder returner() {
        return new ResponseEntityBuilder();
    }
    
    
    public static class ResponseEntityBuilder{
        private int status;
        
        public  ResponseEntityBuilder  status(int status) {
            this.status = status;
            return this;
        }
        
        public <T> ResponseEntity<T> body(T body) {
            ResponseEntity<T> t = new ResponseEntity();
            t.status = this.status;
            t.body = body;
            return t ;
        }
    }

}
