package com.techiebees;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Product_collectors{
    int id;
    String name;
    float price;

    public Product_collectors(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
}
public class collectors {
    /*
    Collectors is a final class that extends Object class.
    It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
    * */
    public static void executecollectors(){
        List<Product_collectors> productsList = new ArrayList<Product_collectors>();
        //Adding Products
        productsList.add(new Product_collectors(1,"HP Laptop",25000f));
        productsList.add(new Product_collectors(2,"Dell Laptop",30000f));
        productsList.add(new Product_collectors(3,"Lenevo Laptop",28000f));
        productsList.add(new Product_collectors(4,"Sony Laptop",28000f));
        productsList.add(new Product_collectors(5,"Apple Laptop",90000f));
        List<Float> productPriceList =
                productsList.stream()
                        .map(x->x.price)         // fetching price
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList);

        //AS SET
        Set<Float> productPriceListset =
                productsList.stream()
                        .map(x->x.price)         // fetching price
                        .collect(Collectors.toSet());   // collecting as list
        System.out.println(productPriceListset);

        //sum in collectors
        Double sumPrices =
                productsList.stream()
                        .collect(Collectors.summingDouble(x->x.price));  // collecting as list
        System.out.println("Sum of prices: "+sumPrices);
        Integer sumId =
                productsList.stream().collect(Collectors.summingInt(x->x.id));
        System.out.println("Sum of id's: "+sumId);

        //average
        Double average = productsList.stream()
                .collect(Collectors.averagingDouble(p->p.price));
        System.out.println("Average price is: "+average);

        //count
        Long noOfElements = productsList.stream()
                .collect(Collectors.counting());
        System.out.println("Total elements : "+noOfElements);
    }
}
