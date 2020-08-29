package com.study.source;

import com.study.source.beans.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SourceApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SourceApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.study.source");
        People bean = context.getBean(People.class);
        bean.say();
        context.close();
    }
}
