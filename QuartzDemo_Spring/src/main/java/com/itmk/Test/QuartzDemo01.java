package com.itmk.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *@Description:
 *@ClassName:QuartzDemo01
 *@Authos:18505
 *@Date:2018/11/20  14:22
 */
public class QuartzDemo01 {

    public static void main(String[] args) {
        //ApplicationContext context=new ClassPathXmlApplicationContext("Application-context-quartz01.xml");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Application-context-Quartz02.xml");
        //ApplicationContext context=new ClassPathXmlApplicationContext("Application-context-Quartz02xml");
    }
}
