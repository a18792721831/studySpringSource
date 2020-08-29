package com.study.source.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jiayq
 * @Date 2020-08-29
 */
@Component
public class People implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    // 1
    public People() {
        System.out.println("1.create");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2.set bean name : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3.set bean factory , name is " + beanFactory.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4.set application context , name is " + applicationContext.getClass().getSimpleName() + " , id is " + applicationContext.getId());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5.post process before initialization , bean name is " + beanName);
        return bean;
    }

    @PostConstruct
    public void init() {
        System.out.println("6.post construct , this name is " + this.getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7.after properties set ");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8.post process after initializattion , bean name is " + beanName);
        return bean;
    }

    public void say() {
        System.out.println("9.normal survival");
    }

    @PreDestroy
    public void destory() {
        System.out.println("10.pre destory");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11.destroy by DisposableBean");
    }
}
