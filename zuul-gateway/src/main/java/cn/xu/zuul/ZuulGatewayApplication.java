package cn.xu.zuul;

import cn.xu.zuul.filter.TokenFilter;
import jdk.nashorn.internal.parser.Token;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulGatewayApplication {

    public static void main(String[] args) {


        SpringApplication.run(ZuulGatewayApplication.class, args);
    }



    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
