package com.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        //Ascending order
        List<String> sortedFruits = fruits.stream().sorted(Comparator.naturalOrder()).toList();
        sortedFruits.forEach(System.out::println);

        List<String> sortedFruits1 = fruits.stream().sorted(((o1, o2) -> o1.compareTo(o2))).toList();
        sortedFruits1.forEach(System.out::println);

        List<String> sortedFruits2 = fruits.stream().sorted().toList();
        sortedFruits2.forEach(System.out::println);
        System.out.println("********************");
        //Descending order
        List<String> sortedFruits3 = fruits.stream().sorted(Comparator.reverseOrder()).toList();
        sortedFruits3.forEach(System.out::println);

        List<String> sortedFruits4 = fruits.stream().sorted(((o1, o2) -> o2.compareTo(o1))).toList();
        sortedFruits4.forEach(System.out::println);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Yashavanth H R", 40000, 24));
        employees.add(new Employee(2, "Pavan C J", 35000, 26));
        employees.add(new Employee(3, "Harshitha", 3000, 22));
        employees.add(new Employee(4, "Priyanka", 50000, 30));

        //Anonymous implementation
        List<Employee> employeesSorted = employees.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        }).toList();
        employeesSorted.forEach(System.out::println);

        //lambda implementation
        List<Employee> employeesSorted1 = employees.stream()
                                        .sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary()))
                                        .toList();
        employeesSorted1.forEach(System.out::println);
        System.out.println("++++++++++++++++");
        List<Employee> employeesSorted2 = employees.stream()
                .sorted((o1, o2) -> (int)(o2.getSalary() - o1.getSalary()))
                .toList();
        employeesSorted2.forEach(System.out::println);
        System.out.println("++++++++++++++++");
        List<Employee> employeesSorted3 = employees.stream()
                .sorted((o1, o2) -> (int)(o1.getAge() - o2.getAge()))
                .toList();
        employeesSorted3.forEach(System.out::println);
        System.out.println("++++++++++++++++");
        List<Employee> employeesSorted4 = employees.stream()
                .sorted((o1, o2) -> (int)(o2.getAge() - o1.getAge()))
                .toList();
        employeesSorted4.forEach(System.out::println);

        System.out.println("++++++++++++++++");
        List<Employee> employeesSorted5 = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        employeesSorted5.forEach(System.out::println);
        System.out.println("++++++++++++++++");
        List<Employee> employeesSorted6 = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .toList();
        employeesSorted6.forEach(System.out::println);

    }
}
