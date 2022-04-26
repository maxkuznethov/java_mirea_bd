package ru.mirea.task14.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SchedulerService {
    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        try {
            FileUtils.cleanDirectory(new File("D:/java/task14/BD log"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
