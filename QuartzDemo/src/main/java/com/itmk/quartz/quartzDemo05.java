package com.itmk.quartz;

import com.itmk.job.MyJob01;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 *@Description:传递参数的2种方式
 *@ClassName:quartzDemo05
 *@Authos:18505
 *@Date:2018/11/20  17:55
 */
public class quartzDemo05 {
    public static void main(String[] args)throws Exception {


        //方式一：.usingJobData("key","value")
        JobDetail jobDetail= JobBuilder.newJob(MyJob01.class).build();
                            //.usingJobData("name","啤酒、饮料")
        //方式二：
        jobDetail.getJobDataMap().put("name","啤酒、饮料");
        jobDetail.getJobDataMap().put("job","优惠大酬宾");

        //Trigger
            Trigger trigger= TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder
                         .cronSchedule("* * * * * ?")).build();

        //Scheduler
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        //注册
        scheduler.scheduleJob(jobDetail,trigger);
        //启动
        scheduler.start();
    }
}
