package com.itmk.quartz;

import com.itmk.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 *@Description:如何使用Quartz
 *@ClassName:quartzDemo01
 *@Authos:18505
 *@Date:2018/11/20  9:27
 */
public class quartzDemo01 {

    public static void main(String[] args) throws SchedulerException {
        /*
        * 1、jobDetail job描述
        * 2、Trigger     触发条件
        * 3、Scheduler   任务调度器
        * */
        //1、创建JobDetail
        JobDetail jobDetail= JobBuilder.newJob(MyJob.class).withIdentity("myJob","myGroup").build();
        //2、创建Triiger出发器
        Trigger trigger= TriggerBuilder.newTrigger().startNow()
                        .withIdentity("我的触发器")
                        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
                        .build();
        //3、创建Schuduler对象
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();

        //4、注册任务和出发器
        scheduler.scheduleJob(jobDetail,trigger);
        //5、开始任务
        scheduler.start();
    }
}

