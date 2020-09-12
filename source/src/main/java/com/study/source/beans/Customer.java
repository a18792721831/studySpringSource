package com.study.source.beans;

import lombok.Data;

/**
 * @author jiayq
 * @Date 2020-09-12
 */
@Data
public class Customer {

    private String name;

    private Subscriber subscriber;

    private Product product;

}
