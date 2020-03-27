package com.ll;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ll.domain.Page;
import com.ll.download.Downloadpage;
import com.ll.parsejson.Parse;

/**
 * @author liulu
 * @create 2019-12-18 10:31
 */
public class Spider {
    public static void main(String[] args) {
       /* ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String skuid = "2860572";
                Downloadpage down = new Downloadpage();
                Page page = down.getPage(skuid);
                Parse parse = new Parse();
                parse.parseJSON(page);
            }
        }, 0, 1, TimeUnit.HOURS); */
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("xxx-pool-%d").build();
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(10, threadFactory);
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String skuid = "2860572";
                Downloadpage down = new Downloadpage();
                Page page = down.getPage(skuid);
                Parse parse = new Parse();
                parse.parseJSON(page);
            }
        }, 0, 30, TimeUnit.SECONDS);
    }

}
