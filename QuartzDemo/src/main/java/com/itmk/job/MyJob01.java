package com.itmk.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*
 *@Description:
 *@ClassName:MyJob01
 *@Authos:18505
 *@Date:2018/11/20  16:17
 */
public class MyJob01 implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail=jobExecutionContext.getJobDetail();

        String name=detail.getJobDataMap().getString("name");
        String job =detail.getJobDataMap().getString("job");

        System.out.println("今日大促销:内容："+name+":"+job+"20:00准时开始");
    }
}
