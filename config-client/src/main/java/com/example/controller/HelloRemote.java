package com.example.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-config-server")
public interface HelloRemote {
    @RequestMapping(value = "/from")
    public String from();
}