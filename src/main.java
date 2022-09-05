import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        // some values from some different examples
        students.add(new Student(1, "Hector", "Mexico", 18, 1));
        students.add(new Student(2, "Sebastian", "Colombia", 15, 1));
        students.add(new Student(3, "Fernando", "Mexico", 22, 2));
        students.add(new Student(4, "Mario", "Colombia", 19, 2));

        classes.add(new Class(1, "Math"));
        classes.add(new Class(2, "English"));
        classes.add(new Class(3, "History"));

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
        System.out.println();

        // Here we call the method getStudentsFromMexico where we filter students by address using stream
        getStudentsFromMexico();
        System.out.println();

        // Here we call the method getStudentsThatAgeIsGreaterThan17 where we filter students by age greater than 17
        getStudentsThatAgeIsGreaterThan17();
        System.out.println();

        // Here we need to group students by id_class we used a stream that collect groupingby id_class, next in the value we have a mapping by name as List
        groupStudentsInClasses();
        System.out.println();
    }

    // List that we are using
    private static List<String> names = new LinkedList<>();
    private static List<Integer> numbers = new LinkedList<>();
    private static List<Student> students = new LinkedList<>();
    private static List<Class> classes = new LinkedList<>();

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
        // We can use the method filter and put a parameter, on this example
        // I put a lambda expression to filter, this expressions mean the element
        // need to starts with the filter that was recived in the method for exmple "J"
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
        System.out.printf("\nNumbers count = %d", numbers.stream().count());

        System.out.println();

        System.out.printf("Names count = %d", names.stream().count());
    }

    // new more complicated examples
    public static void groupStudentsInClasses() {
        // Frist we need a HashMap to save key (id_class) and value (students)
        Map<Integer, List<String>> groups = new HashMap<>();
        // Initialize the stream, collect grouping by id_class, next mapping by name as List
        groups = students.stream()
                .collect(Collectors.groupingBy(Student::getId_class, Collectors.mapping(
                        Student::getName, Collectors.toList()
                )));
        System.out.println(groups);
    }

    public static void getStudentsFromMexico() {
        System.out.println("\nStudents from Mexico: ");
        // Just using a filter by address, in the map we get only the name of the student and finally print the name on console
        students.stream()
                .filter(s -> s.getAddress().equals("Mexico"))
                .map(Student::getName)
                .forEach(System.out::println);
    }

    public static void getStudentsThatAgeIsGreaterThan17() {
        System.out.println("Students greater than 17 years old:");
        // Just using a filter can we have the list of students that has grater than 17 years old
        // at the final we get a List, and we can use the method forEach of the own list to print on console
        students.stream()
                .filter(s -> s.getAge() > 17)
                .map(Student::getName)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}

// class student
class Student {
    private int id;
    private String name;
    private String address;
    private int age;
    private int id_class;

    public Student(int id, String name, String address, int age, int id_class) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.id_class = id_class;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getId_class() {
        return id_class;
    }

}

// class Class, haha is like a course
class Class {
    private int id;
    private String name;

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

