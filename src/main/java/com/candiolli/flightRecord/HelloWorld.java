package com.candiolli.flightRecord;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;

@Label("Hello World")
@Description("Helps the programmer getting started")
public class HelloWorld extends Event {

    @Label("Message")
    String message;

}
