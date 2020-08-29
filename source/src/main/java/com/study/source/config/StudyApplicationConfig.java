package com.study.source.config;

import com.study.source.studyservlet.StudyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

/**
 * @author jiayq
 * @Date 2020-08-24
 */
//@Configuration
public class StudyApplicationConfig {

//    @Bean
    public ServletRegistrationBean<Servlet> dispatcherRegistration(){
        return new ServletRegistrationBean(new StudyServlet());
    }

}
