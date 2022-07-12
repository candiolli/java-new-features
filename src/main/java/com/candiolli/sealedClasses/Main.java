package com.candiolli.sealedClasses;

public class Main {
    public static void main(String[] args) {
        Person employee = new Employee("John");

        System.out.println(employee.sayHello());
    }
}
