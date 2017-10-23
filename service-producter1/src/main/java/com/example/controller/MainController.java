package com.example.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Producer1Application;


@RestController
public class MainController {
	
	private static final Logger LOG = Logger.getLogger(Producer1Application.class.getName());
	
	@Value("${server.port}")
	String port;
	
	/**
	 * 使用 http://localhost:9000/hello?name=aa 访问
	 * @param name 
	 * @return
	 */
	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
		LOG.log(Level.INFO, "===================================================================calling trace service-producer "+ port);
		
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
	
	/**
	 * zipkin 固有方法
	 * @return
	 */
	@Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
