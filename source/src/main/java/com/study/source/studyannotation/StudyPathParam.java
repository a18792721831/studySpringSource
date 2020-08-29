package com.study.source.studyannotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StudyPathParam {

    String value() default "";

}
