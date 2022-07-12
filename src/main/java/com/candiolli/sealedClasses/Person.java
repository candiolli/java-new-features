package com.candiolli.sealedClasses;

public abstract sealed class Person permits Employee, Manager {

    String name;
    public abstract String sayHello();
}

