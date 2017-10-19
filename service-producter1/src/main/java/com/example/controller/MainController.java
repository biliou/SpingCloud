package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
	
	@Value("${server.port}")
	String port;
	
	/**
	 * 使用 http://localhost:9000/hello?name=aa 访问
	 * @param name 
	 * @return
	 */
	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is producer 2  send first messge, from " + port;
    }
	
	/**
	 * 使用 http://localhost:9000/zuul?name=aa 访问
	 * @param name 
	 * @return
	 */
	@RequestMapping("/zuul")
    public String testZuul(@RequestParam String name) {
        return "hello "+name+"，this is one message";
    }
}
