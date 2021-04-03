package com.techiebees;

import java.util.Optional;

public class optional {
    /*
     It is a public final class and used to deal with NullPointerException in Java application.
     You must import java.util package to use this class.
      It provides methods which are used to check the presence of value for particular variable.
    * */
    public static void executeoptional() {
        String[] str = new String[10];
        String lowercaseString = str[5].toLowerCase();//nullpointerexception
        System.out.print(lowercaseString);

        //using Optional
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){  // check for value is present or not
            String lowercaseString2 = str[5].toLowerCase();
            System.out.print(lowercaseString2);
        }else
            System.out.println("string value is not present");

        //using methodref
        checkNull.ifPresent(System.out::println);   // printing value by using method reference
        System.out.println(checkNull.get());    // printing value by using get method
        System.out.println(str[5].toLowerCase());

        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
        // It returns an empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println(empty);//Optional.empty
        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[5]);
        // If value is present, it returns an Optional otherwise returns an empty Optional
        System.out.println("Filtered value: "+value.filter((s)->s.equals("Abc")));//Filtered value: Optional.empty
        System.out.println("Filtered value: "+value.filter((s)->s.equals("JAVA OPTIONAL CLASS EXAMPLE")));//Filtered value: Optional[JAVA OPTIONAL CLASS EXAMPLE]
        // It returns value of an Optional. if value is not present, it throws an NoSuchElementException
        System.out.println("Getting value: "+value.get());//Getting value: JAVA OPTIONAL CLASS EXAMPLE
        // It returns hashCode of the value
        System.out.println("Getting hashCode: "+value.hashCode());//Getting hashCode: -619947648
        // It returns true if value is present, otherwise false
        System.out.println("Is value present: "+value.isPresent());//Is value present: true
        // It returns non-empty Optional if value is present, otherwise returns an empty Optional
        System.out.println("Nullable Optional: "+Optional.ofNullable(str[5]));//Nullable Optional: Optional[JAVA OPTIONAL CLASS EXAMPLE]
        // It returns value if available, otherwise returns specified value,
        System.out.println("orElse: "+value.orElse("Value is not present"));//orElse: JAVA OPTIONAL CLASS EXAMPLE
        System.out.println("orElse: "+empty.orElse("Value is not present"));//orElse: Value is not present
        value.ifPresent(System.out::println);   // printing value by using method reference //JAVA OPTIONAL CLASS EXAMPLE



    }
}
