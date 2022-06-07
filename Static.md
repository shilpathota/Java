# Static

**Understanding of Static Keyword:**

Static Keyword can be used with class, variable, method and block.

Static Methods belong to the class instead of a specific instance. This means, if you make a member static you can access it without object

Static Members are common for all the instances(Objects) of the class but non-static members are separate for each instance of the class

**Static Block:**

Used for initializing the static variables. This block gets executed when the class is loaded in the memory. A class can have multiple static blocs which will be executed in the same sequence in which they have been written into the program.

Example:

```java
class staticExample{
  static int num;
  static string mystr;
  static{
    System.out.Println("Block1");
    num = 68;
    mystr = "Block 1";
  }
  static{
    System.out.Println("Block2");
    num = 98;
    mystr = "Block 2";
  }
  public static void main(String[] args){
        System.out.Println("num : "+num);
        System.out.Println("mystr : "+mystr);
  }
}
//Output:
//Block1
//Block2
//num : 98
//mystr : Block 2
```

**Static Variables:**

- Common to all instances of the class
- Single copy of static variable is created and shared among all instances of the class
- Memory allocation only happens once when the class is loaded in memory.
- They are also known as Class Variables
- Unlike non-static variables such variables are accessed directly in static and non-static methods
    
    Example:
    
    ```java
    class StaticVariables{
      static int var1=77;
      public static void main(String[] args){
        StaticVariables obj = new StaticVariables();
        StaticVariables obj2 = new StaticVariables();
        obj.var1=88;
        obj2.var1=99;
        System.out.Println("var1 : "+obj.var1);
      }
    }
    
    //Output:
    //var1 : 99
    ```
    

In the above example, even though the var1 is accessed with other object, the static variables share same memory across the instances of the class, it overwrites the same memory location of var1 from 88 to 99.

**Static Methods:**

- Can access class variables without using object of the class. However,  non-static methods and non-static variables can be accessed using objects.
- Static Methods can be accessed directly in static and non-static methods.

**Why is Main Method Static?**

This is necessary because main() is called by JVM before any objects are made. Since it is static it can be directly invoked via the class.

**Why Interfaces cannot have static Methods?**

By Default, interfaces are declared as public and abstract. It will never be static. But this changed in Java8, where we have new feature “default methods” in interface.
