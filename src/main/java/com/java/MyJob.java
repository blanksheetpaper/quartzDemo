package com.java;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务
 */
public class MyJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("我正在执行------>");
        //取出封装的数据
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();

    }
}
