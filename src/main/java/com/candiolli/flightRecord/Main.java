package com.candiolli.flightRecord;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    /**
     * TODO needs to finished the implementation
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HelloWorld event = new HelloWorld();
        event.message = "hello, world!";
        event.commit();
        System.out.println("Go");
//        Path p = Paths.get("recording.jfr");
//        for (RecordedEvent e : RecordingFile.readAllEvents(p)) {
//            System.out.println(e.getStartTime() + " : " + e.getValue("message"));
//        }
    }
}
