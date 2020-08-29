package com.study.source.service;

import com.study.source.studyannotation.StudyService;

/**
 * @author jiayq
 * @Date 2020-08-25
 */
@StudyService("helloService")
public class HelloService {

    public String hi(){
        return " hi {service} ";
    }

}
