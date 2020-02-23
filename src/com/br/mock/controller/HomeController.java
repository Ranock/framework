package com.br.mock.controller;

import com.br.annotations.AutoWired;
import com.br.annotations.RestController;
import com.br.mock.service.HomeService;
import com.br.routing.models.ResponseEntity;

@RestController("/")
public class HomeController {
    
    private HomeService homeService;
    
    
    public HomeController( @AutoWired HomeService homeService) {
        super();
        this.homeService = homeService;
    }


    public ResponseEntity<String> retrieveOk(){
        return ResponseEntity.returner().status(200).body(homeService.returnOk());
    }
}
