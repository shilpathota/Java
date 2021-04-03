package com.techiebees;

import java.util.ArrayList;
import java.util.List;

public class forEach {
    /*
    Java provides a new method forEach() to iterate the elements.
    It is defined in Iterable and Stream interface.
    It is a default method defined in the Iterable interface.
    Collection classes which extends Iterable interface can use forEach loop to iterate elements.
    This method takes a single parameter which is a functional interface
    So, you can pass lambda expression as an argument.

    Signature:
    default void forEach(Consumer<super T>action)

    Along with forEach() method, Java provides one more method forEachOrdered().
    It is used to iterate elements in the order specified by the stream.

    Signature:
    void forEachOrdered(Consumer<? super T> action)
    * */
    public static void executeForeach(){
        List<String> gamesList = new ArrayList<String>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hocky");
        System.out.println("------------Iterating by passing lambda expression--------------");
        gamesList.forEach(games -> System.out.println(games));

        //method references
        gamesList.forEach(System.out::println);

        //foreach ordered
        gamesList.stream().forEachOrdered(games -> System.out.println(games));

        gamesList.stream().forEachOrdered(System.out::println);



    }
}
