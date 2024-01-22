package com.sparta.calendar.autoAppConfig;

import com.sparta.calendar.AutoAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBean {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

}
