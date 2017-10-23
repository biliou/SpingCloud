package com.example.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	 private static final Logger LOG = Logger.getLogger(ConsumerController.class.getName());

    @Autowired
    HelloRemote HelloRemote;
    
    @Value("${server.port}")
	String port;
	
    /**
     * 通过 http://localhost:9003/hello/neo 访问
     * @param name
     * @return
     */
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
    	LOG.log(Level.INFO, "===================================================================calling trace service-consumer  " + port);
    	
        return HelloRemote.hello(name);
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
