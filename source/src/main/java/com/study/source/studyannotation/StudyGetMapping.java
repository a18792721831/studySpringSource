package com.study.source.studyannotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StudyGetMapping {

    String value() default "";

}
