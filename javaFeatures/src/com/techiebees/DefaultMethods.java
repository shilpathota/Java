package com.techiebees;
interface Sayable_default{
    // Default method
    default void say(){
        System.out.println("Hello, this is default method");
    }
    // Abstract method
    void sayMore(String msg);

    // static method
    static void sayLouder(String msg){
        System.out.println(msg);
    }

}
abstract class AbstractClass{
    public AbstractClass() {        // constructor
        System.out.println("You can create constructor in abstract class");
    }
    abstract int add(int a, int b); // abstract method
    int sub(int a, int b){      // non-abstract method
        return a-b;
    }
    static int multiply(int a, int b){  // static method
        return a*b;
    }
}
public class DefaultMethods extends AbstractClass implements Sayable_default{
    public void sayMore(String msg){        // implementing abstract method
        System.out.println(msg);
    }
    public int add(int a, int b){        // implementing abstract method
        return a+b;
    }
    public static void executedefaultmethods(){
        /*
        Java provides a facility to create default methods inside the interface.
        Methods which are defined inside the interface and tagged with default are known as default methods.
        These methods are non-abstract methods.

        You can override default method also to provide more specific implementation for the method.
        * */
        DefaultMethods dm = new DefaultMethods();
        dm.say();   // calling default method
        dm.sayMore("Work is worship");  // calling abstract method
        Sayable_default.sayLouder("Helloooo...");   // calling static method

        //After having default and static methods inside the interface, we think about the need of abstract class in Java.
        // An interface and an abstract class is almost similar except that you can create constructor in the abstract class whereas you can't do this in interface.
        int result1 = dm.add(20, 10);    // calling abstract method
        int result2 = dm.sub(20, 10);    // calling non-abstract method
        int result3 = AbstractClass.multiply(20, 10); // calling static method
        System.out.println("Addition: "+result1);
        System.out.println("Substraction: "+result2);
        System.out.println("Multiplication: "+result3);




    }
}
