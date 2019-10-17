package cn.xu.apib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiBApplication {

    @RequestMapping("/")
    public String getApiByA(){
        return "我是B项目";
    }
    public static void main(String[] args) {
        SpringApplication.run(ApiBApplication.class, args);
    }

}
