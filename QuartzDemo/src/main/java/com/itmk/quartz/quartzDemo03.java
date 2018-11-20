package com.itmk.quartz;

import com.itmk.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/*
 *@Description:设置开始结束时间来运行
 *@ClassName:quartzDemo03
 *@Authos:18505
 *@Date:2018/11/20  10:35
 */
public class quartzDemo03 {

    public static void main(String[] args)throws Exception {

        //1、创建Scheduler
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        //2、创建Detail
        JobDetail jobDetail= JobBuilder.newJob(MyJob.class).build();
        //3、Trigger
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(DailyTimeIntervalScheduleBuilder
                        .dailyTimeIntervalSchedule()
                        .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(17,47))//执行时间17：47开始
                        .withIntervalInSeconds(1)//每秒执行
                        .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(20,0))//结束时间20:00结束
                        .onDaysOfTheWeek(DailyTimeIntervalScheduleBuilder.MONDAY_THROUGH_FRIDAY))//星期一至星期五
                        .startNow()//现在开始执行
                        .build();
        //注册触发器和任务
        scheduler.scheduleJob(jobDetail,trigger);
        //启动
        scheduler.start();
    }

}
