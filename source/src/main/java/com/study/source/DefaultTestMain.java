package com.study.source;

import com.study.source.beans.Customer;
import com.study.source.beans.Product;
import com.study.source.beans.Subscriber;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

/**
 * @author jiayq
 * @Date 2020-09-12
 */
public class DefaultTestMain {

    public static void main(String[] args) throws NoSuchFieldException {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        RootBeanDefinition customer = new RootBeanDefinition(Customer.class);
        RootBeanDefinition subscriber = new RootBeanDefinition(Subscriber.class);
        RootBeanDefinition product = new RootBeanDefinition(Product.class);
        factory.registerBeanDefinition("customer", customer);
        factory.registerBeanDefinition("subscriber", subscriber);
        factory.registerBeanDefinition("product", product);
        Product productx = factory.createBean(Product.class);
        productx.setName("prod");
        factory.registerSingleton("product", productx);
        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("before");
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("after");
                return bean;
            }
        });
        factory.registerDependentBean("subscriber", "product");
        factory.registerDependentBean("customer", "subscriber");
        DependencyDescriptor customerDes = new DependencyDescriptor(Customer.class.getDeclaredField("subscriber"), true);
        DependencyDescriptor subscriberDes = new DependencyDescriptor(Subscriber.class.getDeclaredField("product"), true);
        factory.resolveDependency(customerDes, "customer");
        factory.resolveDependency(subscriberDes, "subscriber");
        System.out.println(factory.autowire(Customer.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true));
        System.out.println(factory.autowire(Subscriber.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true));
        System.out.println(factory.getBean("product",Product.class));
    }

}
