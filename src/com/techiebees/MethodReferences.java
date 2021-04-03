package com.techiebees;

import java.util.function.BiFunction;

interface Sayable_Method{
    void say();
}
class Arithmetic{
    public static int add(int a, int b){
        return a+b;
    }
}

interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}

public class MethodReferences {
    /*
    Method reference is used to refer method of functional interface.
    It is compact and easy form of lambda expression.
    Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.
    There are following types of method references in java:

           1. Reference to a static method.
           Syntax: ContainingClass::staticMethodName
           2. Reference to an instance method.
            Syntax:containingObject::instanceMethodName
           3. Reference to a constructor.
           Syntax:ClassName::new
    */
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public void saySomething_nonstatic() {
        System.out.println("Hello, this is not static method.");
    }
    public static void executeMethodReferences() {
        // Referring static method
        Sayable_Method sayable = MethodReferences::saySomething;
        // Calling interface method
        sayable.say();

        //using BiFunction
        BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
        int result = adder.apply(10, 20);
        System.out.println(result);


        //Referring instance method

        MethodReferences methodReference = new MethodReferences(); // Creating object
        // Referring non-static method using reference
        Sayable_Method sayable_nonstatic = methodReference::saySomething_nonstatic;
        // Calling interface method
        sayable_nonstatic.say();
        // Referring non-static method using anonymous object
        Sayable_Method sayable2_nonstatic = new MethodReferences()::saySomething_nonstatic; // You can use anonymous object also
        // Calling interface method
        sayable2_nonstatic.say();

        //Referring Constructor
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}
