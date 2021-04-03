package com.techiebees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@FunctionalInterface  //It is optional
interface Drawable{
    public void draw();
}
interface Sayable{
    public String say(String name);
}
interface Addable{
    int add(int a,int b);
}
class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class lambdaexpression {
    public static void executeExample(){
        //The Lambda expression is used to provide the implementation of an interface which has functional interface
        //Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface. Java provides an anotation @FunctionalInterface, which is used to declare an interface as functional interface.
        //Syntax:(argument-list) -> {body}
        //Example without arguments
        int width=10;
        Drawable d2=()->{
            System.out.println("Drawing "+width);
        };
        d2.draw();
        //Example with arguments
        // Lambda expression with single parameter.
        Sayable s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sonoo"));

        // You can omit function parentheses
        Sayable s2= name ->{
            return "Hello, "+name;
        };
        System.out.println(s2.say("Sonoo"));

        // Multiple parameters in lambda expression
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));

        //foreach loop
        List<String> list1=new ArrayList<String>();
        list1.add("ankit");
        list1.add("mayank");
        list1.add("irfan");
        list1.add("jai");

        list1.forEach(
                (n)->System.out.println(n)
        );

        // You can pass multiple statements in lambda expression
        Sayable person = (message)-> {
            String str1 = "I would like to say, ";
            String str2 = str1 + message;
            return str2;
        };
        System.out.println(person.say("time is precious."));

        //Thread Example with lambda
        Runnable r2=()->{
            System.out.println("Thread2 is running...");
        };
        Thread t2=new Thread(r2);
        t2.start();

        //using objects
        List<Product> list=new ArrayList<Product>();

        //Adding Products
        list.add(new Product(1,"HP Laptop",25000f));
        list.add(new Product(3,"Keyboard",300f));
        list.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(list,(p1, p2)->{
            return p1.name.compareTo(p2.name);
        });
        for(Product p:list){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }

        // using lambda to filter data
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);

        // using lambda to iterate through collection
        filtered_data.forEach(
                product -> System.out.println(product.name+": "+product.price)
        );


    }
}
