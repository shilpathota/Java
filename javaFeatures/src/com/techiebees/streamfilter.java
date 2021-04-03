package com.techiebees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product_streamfilter{
    int id;
    String name;
    float price;
    public Product_streamfilter(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class streamfilter {
    /*
    Java stream provides a method filter() to filter stream elements on the basis of given predicate.
    Suppose you want to get only even elements of your list then you can do this easily with the help of filter method.

    This method takes predicate as an argument and returns a stream of consisting of resulted elements.
    syntax: Stream<T> filter(Predicate<? super T> predicate)
    predicate: It takes Predicate reference as an argument. Predicate is a functional interface. So, you can also pass lambda expression here.

    * */
    public static void executestreamfilter() {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        productsList.stream()
                .filter(p ->p.price> 30000)   // filtering price
                .map(pm ->pm.price)          // fetching price
                .forEach(System.out::println);  // iterating price
        //to List
        List<Float> pricesList =  productsList.stream()
                .filter(p ->p.price> 30000)   // filtering price
                .map(pm ->pm.price)          // fetching price
                .collect(Collectors.toList());
        System.out.println(pricesList);

    }

}
