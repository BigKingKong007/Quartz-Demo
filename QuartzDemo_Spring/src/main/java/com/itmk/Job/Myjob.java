package com.itmk.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*
 *@Description:
 *@ClassName:Myjob
 *@Authos:18505
 *@Date:2018/11/20  14:12
 */
public class Myjob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz+spring整合" +
                "");
    }
}
