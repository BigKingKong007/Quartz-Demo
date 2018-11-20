package com.itmk.quartz;

import com.itmk.job.MyJob01;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/*
 *@Description:设置执行频率
 *@ClassName:quartzDemo02
 *@Authos:18505
 *@Date:2018/11/20  9:57
 */
public class quartzDemo02 {

    public static void main(String[] args)throws Exception {

        //创建Jobdetail
        JobDetail jobDetail= JobBuilder.newJob(MyJob01.class)
                .withIdentity("Myjob","myGroup")
                .usingJobData("name","香烟、啤酒")
                .usingJobData("job","优惠大酬宾")
                .build();
        //触发器
        Trigger trigger= TriggerBuilder.newTrigger().withIdentity("出发器1")
                        .startNow()//从现在开始执行
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每秒执行
                        .repeatForever())//一直执行
                        .build();

        //创建Scheduler
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        //任务调度
        scheduler.scheduleJob(jobDetail,trigger);
        //开始任务
        scheduler.start();

    }
}
