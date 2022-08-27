### Hello I am Luis, on this repository you can learn about Stream and Lambda expressions with Java.

 `stream.limit()`  -> ***To Limit the elements***
 
 `stream.sorted()`  -> ***To order elements in a List***
 
 `stream.filter`  -> ***To filter by some value***
 
 `stream.map()`  -> ***To transform elements***
 
 `stream.count()`  -> ***To get the number of elements***
 

**limit**
``` java
	public static void limit(int limit) {
        // We can limit the elements of a list using the function limit and put a number like
	// limit in the parameters
        // on this case this number is received in the method.
        System.out.printf("Limit, limited to %d first values\n", limit);
        numbers.stream().limit(limit).forEach(x -> System.out.print(x+" "));
    }
```
**order** 
``` java
	public static void order() {
        // First we order names with default method sorted, that by default is ASC
        System.out.println("Order, ASC");
        names.stream().sorted().forEach(System.out::println);
        System.out.println();
        // Next we order names using a lambda expression, we compare y to x, x is first
	// value, y is next value
        System.out.println("Order, DESC");
        names.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
    }
```
**filter**
``` java
	public static void filter(String filter) {
        // We can use the method filter and put a parameter, on this example 
        // I put a lambda expression to filter, this expressions mean the element
        // need to starts with the filter that was recived in the method for exmple "J"
        System.out.println("Filter, startsWith: " + filter);
        names.stream().filter(x -> x.startsWith(filter)).forEach(System.out::println);
    }
```
**transform**
``` java
	public static void transform() {
        // Here we transform each number multiply by 10 after this, we will subtract 1
        System.out.println("Transform, n * 10 - 1");
        numbers.stream().map(x -> x*10-1).forEach(System.out::println);
        System.out.println();
        // Here we transform each element of names to upperCase using the method map
	// and String class
        System.out.println("Transform, name to upperCase");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
```
**count**
``` java
	public static void count() {
        // We can use the method count and this method returns a long number, 
	// that number is the number of elements in the list
        System.out.printf("Numbers count = %d", numbers.stream().count());
        System.out.println();
        System.out.printf("Names count = %d", names.stream().count());
    }
```    

Best, @lchavez1.

That readme file was crafted by me using pandao.guthub.io.
