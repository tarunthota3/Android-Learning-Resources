package com.example.module6;

public class Person {
    String name;
    long id;
    int age;
    Address address;


    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
