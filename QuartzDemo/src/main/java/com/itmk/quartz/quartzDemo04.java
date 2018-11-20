package com.itmk.quartz;

import com.itmk.job.MyJob01;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 *@Description:使用Cron语句来定义执行时间
 *@ClassName:quartzDemo04
 *@Authos:18505
 *@Date:2018/11/20  10:35
 */
public class quartzDemo04 {

    public static void main(String[] args)throws Exception {
        //创建Scheduler
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //创建JobDetail
        JobDetail jobDetail=JobBuilder.newJob(MyJob01.class)
                            .usingJobData("name","毛衣、毛裤")
                            .usingJobData("job","优惠大酬宾")
                            .build();
        //创建Trigger
        Trigger trigger=TriggerBuilder.newTrigger()
                        .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//使用Cron语句
                        .withIdentity("MyTrigger")
                        .build();

        //注册触发器和Detail
        scheduler.scheduleJob(jobDetail,trigger);
        //启动
        scheduler.start();

    }
}
