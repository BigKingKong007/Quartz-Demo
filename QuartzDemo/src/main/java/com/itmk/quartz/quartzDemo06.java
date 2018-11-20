package com.itmk.quartz;

import com.itmk.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;


/*
 *@Description:Calendar排除
 *@ClassName:quartzDemo06
 *@Authos:18505
 *@Date:2018/11/20  17:58
 */
public class quartzDemo06 {

    public static void main(String[] args)throws Exception {
        AnnualCalendar annualCalendar=new AnnualCalendar();
        Calendar calendar=new GregorianCalendar();
        calendar.set(Calendar.MONTH,10);
        calendar.set(Calendar.DATE,21);
        //不包含11月20日
        annualCalendar.setDayExcluded(calendar,true);

        //Sceduler
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
       scheduler.addCalendar("MyJob",annualCalendar,false,false);

        //创建Detail
        JobDetail detail=JobBuilder.newJob(MyJob.class).build();


        //创建Trigger
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule()

                            .withIntervalInSeconds(3)
                            .repeatForever())
                            .modifiedByCalendar("MyJob")
                            .startNow()
                            .build();
        //注册
        scheduler.scheduleJob(detail,trigger);
        //启动
        scheduler.start();

    }

}
