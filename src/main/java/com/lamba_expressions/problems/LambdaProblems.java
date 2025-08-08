package com.lamba_expressions.problems;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface OddEven{
    int check(int n);
}
interface Product{
    int multiply(int a, int b);
}

interface ThreadExample extends Runnable{
    void run();
}

interface Calculator{
    int operate(int a, int b);
}
interface StringOperation{
    String toUpper(String str);
    default String toLower(String str){
        return str.toLowerCase();
    }
}
public class LambdaProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = sc.nextInt();
        //Odd or Even
        OddEven num1 =  (num) -> (num % 2 == 0 ? 1 : 0);
        if(num1.check(n) == 1){
            System.out.println(n + " is Even");
        }
        else{
            System.out.println(n + " is Odd");
        }
        System.out.print("Enter second Number: ");

        //Product of two numbers
        int m = sc.nextInt();
        Product mul = (a, b) -> a * b;
        System.out.println("Product is: "+mul.multiply(m, n));

        List<String> list = Arrays.asList("Yashavanth", "Pavan", "Harshitha", "Priyanka");
        //Using method reference
        list.sort(String::compareTo);
        System.out.println("Sorted List using method reference: ");
        list.forEach(System.out::println);

        System.out.println("Sorting using comparator:");
        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
       for(String s: list){
           System.out.println(s);
       }

       System.out.println("Runnable using lambda expression:");
        ThreadExample threadExample = () -> {
           System.out.println("Hello from Lambda Thread");
        };
       Thread ts = new Thread(threadExample);
       threadExample.run();

       System.out.print("Enter a String: ");
       String input = sc.next();
       Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
       String reversed = reverse.apply(input);

       System.out.println("Original: " + input);
       System.out.println("Reversed: " + reversed);

       Calculator add =(a, b) -> a + b;
       System.out.println(add.operate(2, 4));
       Calculator sub = (a, b) -> a - b;
       System.out.println(sub.operate(3, 2));

       Calculator prod = (a, b) -> a * b;
       System.out.println(prod.operate(2, 4));

       List<String> names = Arrays.asList("Yashavanth", "Pavan", "Harshitha", "Priyanka", "","Ankitha", "Amar");
        System.out.println("Names size: "+names.size());
        Predicate<String> isNotEmpty = str -> !str.isEmpty();

        List<String> filtered = names.stream().filter(isNotEmpty).toList();
        System.out.println("Filtered Size: "+filtered.size());
        filtered.forEach(System.out::println);

        System.out.print("Enter a value: ");
        String number = sc.next();
        Function<String, Integer>  stringToInteger = str -> {
           return Integer.parseInt(str);
        };
        System.out.println("String to Integer: "+stringToInteger.apply(number));

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        Function<Integer, String> intToString = n1 ->  {
           return String.valueOf(n1);
        };
        System.out.println("Inreger to String: " + intToString.apply(num));

        Consumer<String> printUpperCase = str -> {
            System.out.println(str.toUpperCase());
        };
        printUpperCase.accept(input);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Consumer<Integer> printSquare = num2 -> {
             System.out.println(num2+" Square is: "+num2 * num2);
        };
        numbers.forEach(printSquare);


        // Stream API
        //Given a list of integers, use Stream API to filter all even numbers and collect them into a new list.
        List<Integer> evenList = numbers.stream().filter(a1 -> a1 % 2 == 0).toList();
        System.out.println("Even Numbers: ");
        evenList.forEach(System.out::println);
        //Find the maximum number in a list using streams.
        Integer maxNumber = numbers.stream().max(Integer::compareTo).orElse(null);
        System.out.println("Maximum Number: " + maxNumber);

        Integer minNUmber = numbers.stream().min(Integer::compareTo).orElse(null);
        System.out.println("Minimum Number: " + minNUmber);
        //Given a list of strings, use streams to return a list of strings that start with the letter “A”.
        List<String> list2 = names.stream().filter(name -> name.startsWith("A")).toList();
        System.out.println("Names starting with A: ");
        list2.forEach(System.out::println);

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Yashavanth H R", 25, 40000, "HR"),
                new Employee(2, "Pavan C J", 26, 35000, "Developer"),
                new Employee(3, "Harshitha", 26, 30000, "Developer"),
                new Employee(4, "Priyanka", 24, 20000, "Designer")
        );
        //Given a list of Employee objects, filter all employees with salary > 30,000.
        List<Employee> emp = employees.stream().filter(sal -> sal.getSalary() > 30000).toList();
        System.out.println("Employees with salary greater than 30000: ");
        emp.forEach(System.out::println);

       // Convert a list of strings into uppercase using map().
        List<String > toUpper = names.stream().map(name -> name.toUpperCase()).toList();
        System.out.println("Names in Upper Case: ");
        toUpper.forEach(System.out::println);
        // Convert a list of strings into lowercase using map().
        List<String > toLower = names.stream().map(name -> name.toLowerCase()).toList();
        System.out.println("Names in Lower Case: ");
        toLower.forEach(System.out::println);

        //Use reduce() to calculate the sum of all numbers in a list.
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all numbers: " + sum);

        //Sort a list of Employee objects by age using Stream and Comparator.
        List<Employee> employeeList = employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).toList();
        System.out.println("Employees sorted by age: ");
        employeeList.forEach(System.out::println);
        //Group a list of Employee by department using Collectors.groupingBy().
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department: ");
        groupedByDepartment.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(System.out::println);
        });

        //Count the number of unique words in a sentence using Stream API.
        System.out.print("Enter a sentence: ");
        sc.nextLine(); // Consume the newline character left by nextInt()
        String sentence = sc.nextLine();

        Set<String> uniqueWords = Arrays.stream(sentence
                        .toLowerCase()                // Convert to lowercase for case-insensitive counting
                        .replaceAll("[^a-z0-9\\s]", "") // Remove punctuation
                        .split("\\s+"))               // Split by whitespace
                .filter(word -> !word.isEmpty()) // Exclude empty strings
                .collect(Collectors.toSet());   // Collect unique words into a set

        System.out.println("Number of unique words: " + uniqueWords.size());
        System.out.println("Unique words: " + uniqueWords);
    }
}
