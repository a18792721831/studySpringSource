package com.study.source.studyannotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StudyAutowaired {

    String value() default "";

}
