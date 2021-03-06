package org.service.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class ServiceTurbineApplication {
	public static void main(String[] args) {
		 SpringApplication.run( ServiceTurbineApplication.class, args );
	}
	 @Bean  
    public ServletRegistrationBean getServlet(){  
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();  
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);  
        registrationBean.setLoadOnStartup(1);  
        registrationBean.addUrlMappings("/hystrix.stream");  
        registrationBean.setName("HystrixMetricsStreamServlet");  
        registrationBean.setName("HystrixMetricsStreamServlet");  
        return registrationBean;  
      
    }
}
