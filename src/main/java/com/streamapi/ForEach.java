package com.streamapi;

import java.util.*;

class Person
{
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ForEach {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "yashavanth", 24));
        personList.add(new Person(2, "pavan", 24));
        personList.add(new Person(3, "Harshitha", 25));
        personList.add(new Person(1, "priyanka", 22));
        personList.forEach(System.out::println);
        personList.forEach((person) -> {
            System.out.println("age: " + person.getAge());
            System.out.println("name: " + person.getName());
        });
        personList.stream().forEach((person) -> {
            System.out.println("age: " + person.getAge());
            System.out.println("name: " + person.getName());
        });


        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person(1, "yashavanth", 24));
        personSet.add(new Person(2, "pavan", 24));
        personSet.add(new Person(3, "Harshitha", 25));
        personSet.add(new Person(1, "priyanka", 22));

        personSet.forEach((person) -> {
            System.out.println("age: " + person.getAge());
            System.out.println("name: " + person.getName());
        });
        personSet.stream().forEach((person) -> {
            System.out.println("age: " + person.getAge());
            System.out.println("name: " + person.getName());
        });
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "yashavanth", 24));
        personMap.put(2, new Person(2, "pavan", 24));
        personMap.put(3, new Person(3, "Harshitha", 25));
        personMap.put(4, new Person(1, "priyanka", 22));

        personMap.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v.getName());
        });

    }

}
