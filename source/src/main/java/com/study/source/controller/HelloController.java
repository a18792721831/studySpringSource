package com.study.source.controller;

import com.study.source.service.HelloService;
import com.study.source.studyannotation.StudyAutowaired;
import com.study.source.studyannotation.StudyController;
import com.study.source.studyannotation.StudyGetMapping;
import com.study.source.studyannotation.StudyPathParam;

/**
 * @author jiayq
 * @Date 2020-08-25
 */
@StudyController("hello")
public class HelloController {

    @StudyAutowaired("helloService")
    private HelloService helloService;

    @StudyGetMapping("hi")
    public String hi(@StudyPathParam("name") String name) {
        return "hi {controller}: " + helloService.hi() + name;
    }

}
