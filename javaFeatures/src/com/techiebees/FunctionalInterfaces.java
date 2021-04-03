package com.techiebees;

//NON FUNCTIONAL INTERFACE
interface Doable{
    default void doIt(){
        System.out.println("Do it now");
    }
}
@FunctionalInterface
interface sayable extends Doable{
    void say(String msg);//abstract method
    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);
}
public class FunctionalInterfaces implements sayable{
    /*
    An Interface that contains exactly one abstract method is known as functional interface.
    It can have any number of default, static methods but can contain only one abstract method.
    It can also declare methods of object class.

    Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
    It is a new feature in Java, which helps to achieve functional programming approach.

    @FunctionalInterface
        interface Doable extends sayable{
            // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface
            void doIt();
        }
    * */
    //Interfcae method implementation
    public void say(String msg){
        System.out.println(msg);
    }
    public static void executeFunctionalInterfaces(){
        FunctionalInterfaces fie = new FunctionalInterfaces();
        fie.say("Hello there");
        fie.doIt();//method from non functional interface
    }

}
