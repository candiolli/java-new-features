package com.candiolli.sealedClasses;

public final class Employee extends Person {

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello, my name is " + name;
    }
}
