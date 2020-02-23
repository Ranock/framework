package com.br.mock.service;

import com.br.annotations.Service;

@Service
public class HomeService {
    public String returnOk() {
        return "OK";
    }
}
