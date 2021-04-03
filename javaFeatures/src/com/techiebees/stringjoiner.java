package com.techiebees;

import java.util.StringJoiner;

public class stringjoiner {
    /*
        Java added a new final class StringJoiner in java.util package.
        It is used to construct a sequence of characters separated by a delimiter.
        Now, you can create string by passing delimiters like comma(,), hyphen(-) etc.
        You can also pass prefix and suffix to the char sequence.
    * */
    public static void executestringjoiner(){
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter
        // We can set default empty value.
        joinNames.setEmptyValue("It is empty");
        System.out.println(joinNames);

        // Adding values to StringJoiner
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");
        joinNames.add("Raheem");

        System.out.println(joinNames);//Rahul,Raju,Peter,Raheem

        // Returns length of StringJoiner
        int length = joinNames.length();
        System.out.println("Length: "+length);

        // Returns StringJoiner as String type
        String str = joinNames.toString();
        System.out.println(str);

        // Now, we can apply String methods on it
        char ch = str.charAt(3);
        System.out.println("Character at index 3: "+ch);



        StringJoiner joinNames2 = new StringJoiner(",", "[", "]");
        // Adding values to StringJoiner
        joinNames2.add("Rahul");
        joinNames2.add("Raju");
        joinNames2.add("Peter");
        joinNames2.add("Raheem");

        System.out.println(joinNames2); //[Rahul,Raju,Peter,Raheem]

        // Merging two StringJoiner
        StringJoiner merge = joinNames.merge(joinNames2);
        System.out.println(merge);
    }
}
