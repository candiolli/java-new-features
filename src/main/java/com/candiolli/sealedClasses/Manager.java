package com.candiolli.sealedClasses;

public final class Manager extends Person {
    @Override
    public String sayHello() {
        return "Hello, my name is " + name;
    }
}
