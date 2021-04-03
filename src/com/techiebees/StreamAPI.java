package com.techiebees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product_Stream{
    int id;
    String name;
    float price;
    public Product_Stream(int id, String name, float price) {
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
public class StreamAPI {

    /*
    Stream provides following features:

    1. Stream does not store elements.
        It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
    2. Stream is functional in nature.
        Operations performed on a stream does not modify it's source.
        For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
    3. Stream is lazy and evaluates code only when required.
    4. The elements of a stream are only visited once during the life of a stream.
        Like an Iterator, a new stream must be generated to revisit the same elements of the source.

        we can use stream to filter, collect, print, and convert from one data structure to other etc.
    * */
    public static void executeStream() {
        List<Product_Stream> productsList = new ArrayList<Product_Stream>();
        //Adding Products
        productsList.add(new Product_Stream(1,"HP Laptop",25000f));
        productsList.add(new Product_Stream(2,"Dell Laptop",30000f));
        productsList.add(new Product_Stream(3,"Lenevo Laptop",28000f));
        productsList.add(new Product_Stream(4,"Sony Laptop",28000f));
        productsList.add(new Product_Stream(5,"Apple Laptop",90000f));

        //stream usage
        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price > 30000)// filtering data
                .map(p->p.price)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);

        //stream iterations
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);

        //filter and iteration
        productsList.stream()
                .filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));

        //reduce() method -> repeated operations like finding the sum of numbers, or accumulating elements into a list.
        // This is more compact approach for filtering data
        Float totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price
        System.out.println(totalPrice);
        // More precise code
        float totalPrice2 = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);
        // Using Collectors's method to sum the prices.
        double totalPrice3 = productsList.stream()
                .collect(Collectors.summingDouble(product->product.price));
        System.out.println(totalPrice3);

        // max() method to get max Product price
        Product_Stream productA = productsList.stream()
                .max((product1, product2)->
                        product1.price > product2.price ? 1: -1).get();

        System.out.println(productA.price);
        // min() method to get min Product price
        Product_Stream productB = productsList.stream()
                .max((product1, product2)->
                        product1.price < product2.price ? 1: -1).get();
        System.out.println(productB.price);

        // count number of products based on the filter
        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);

        // Converting product List into Set
        Set<Float> productPriceList =
                productsList.stream()
                        .filter(product->product.price < 30000)   // filter product on the base of price
                        .map(product->product.price)
                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
        System.out.println(productPriceList);

        // Converting Product List into a Map
        Map<Integer,String> productPriceMap =
                productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));

        System.out.println(productPriceMap);

        //using method reference with stream
        List<Float> productPriceList_methodref =
                productsList.stream()
                        .filter(p -> p.price > 30000) // filtering data
                        .map(Product_Stream::getPrice)         // fetching price by referring getPrice method
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList_methodref);


    }
}
