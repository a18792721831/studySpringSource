package com.study.source.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-08-29
 */
@Component
public class ApplicationLis implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(" event : " + event);
    }
}
