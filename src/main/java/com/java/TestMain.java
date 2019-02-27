package com.java;


import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestMain {


    public static void main(String[] args) throws SchedulerException {
        //创建job
        Map map = new HashMap();
        map.put("name", "nihao");
        map.put("some", "test");
        JobDataMap jobData = new JobDataMap(map);//封装数据
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").setJobData(jobData)
                .build();

        //创建触发器
        /*SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1").startNow().
                withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(4)       //单位为秒
                                .repeatForever()
                ).build();*/
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0 54 11 * * ?")  //秒 分 时 日 月 周
                ).build();

        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, cronTrigger);
        scheduler.start();

    }
}
