import java.util.LinkedList;
import java.util.List;

// Hello I am Luis, today we are using declarative code added in Java 8 version

public class main {

    // main method
    public static void main(String[] args) {

        // Here we add some random values to each list
        names.add("Juan");
        names.add("Luis");
        names.add("Jonathan");
        names.add("Adrian");
        names.add("Kevin");

        numbers.add(1);
        numbers.add(14);
        numbers.add(8);
        numbers.add(85);
        numbers.add(9);

        //First we put a head block
        System.out.println("Names:");
        //The parameter in forEach is a method reference
        names.stream().forEach(System.out::println);

        System.out.println();

        System.out.println("Numbers:");
        numbers.stream().forEach(System.out::println);
        System.out.println();

        // Here we call to the method order
        order();
        System.out.println();

        // Here we call to the method filter and we put some filter character
        filter("J");
        System.out.println();

        // Here we call the method transform
        transform();
        System.out.println();

        // Here we call the method limit, and put a limit number
        limit(3);
        System.out.println();

        // Here we call the method count to get the total number of elements
        count();
    }

    // List that we are using
    private static List<String> names = new LinkedList<>();
    private static List<Integer> numbers = new LinkedList<>();

    public static void limit(int limit) {
        // We can limit the elements of a list using the function limit and put a number like limit in the parameters
        // on this case this number is received in the method.
        System.out.printf("Limit, limited to %d first values\n", limit);
        numbers.stream().limit(limit).forEach(x -> System.out.print(x+" "));
    }

    public static void order() {
        // First we order names with default method sorted, that by default is ASC
        System.out.println("Order, ASC");
        names.stream().sorted().forEach(System.out::println);

        System.out.println();

        // Next we order names using a lambda expression, we compare y to x, x is first value, y is next value
        System.out.println("Order, DESC");
        names.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
    }

    public static void filter(String filter) {
        System.out.println("Filter, startsWith: " + filter);
        names.stream().filter(x -> x.startsWith(filter)).forEach(System.out::println);
    }

    public static void transform() {
        // Here we transform each number multiply by 10 after this, we will subtract 1
        System.out.println("Transform, n * 10 - 1");
        numbers.stream().map(x -> x*10-1).forEach(System.out::println);

        System.out.println();

        // Here we transform each element of names to upperCase using the method map and String class
        System.out.println("Transform, name to upperCase");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static void count() {
        // We can use the method count and this method returns a long number, that number is the number of elements in the list
        System.out.printf("Numbers count = %d", numbers.stream().count());

        System.out.println();

        System.out.printf("Names count = %d", names.stream().count());
    }
}
