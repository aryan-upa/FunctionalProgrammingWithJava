/*
The Optional Class helps us to tackle the problem of null Pointer Exception
    with providing us some value rather than null.

    Optional is a GENERIC CLASS, so class name provided using object initialization,
        will determine what type of data will be stored in the object of that optional.

    We can initialize an optional class object by Optional.empty() method.
    We can initialize an optional class object by Optional.of(data) method, and
        it initializes the optional object with the data provided.

    It has multiple methods in it.

    isPresent -> Whether something is present in the optional or not.
    isEmpty -> Whether the optional is empty or not.
    orElse(data) -> It returns the value in the optional if present, if not,
        it returns the data provided.
    ofNullable -> When we need to initialize an optional object having a null value.
    map() -> the map method allows us to perform some operation on the data which is
        present in the optional, and thus we can use it before worrying about whether
        the optional is null or not.

    But we need to initialize the variable with the Optional.ofNullable method so that
        the optional class knows that the variable can store a null value.
    orElseGet(Supplier) -> if there is no value in optional this method returns the
        value taking it from the supplier.

    ifPresent() -> this method allows us to do some work if there is data present in the optional.
    ifPresentOrElse -> this method returns or does 1 thing if data is present in optional
        or does the other thing if the data is not present.


 */

package OptionalCrashCourse;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
//        System.out.println(empty);

        empty = Optional.of("aryan");
        // putting null here, makes the program return a nullPointerException when used.
//        System.out.println(empty.orElse("noNameYet"));
        // prints aryan.

        Optional<String> empty2 = Optional.ofNullable(null);
        // This way we can initialize an optional with a null value.

        Optional<String> helloOptional = Optional.ofNullable(null);
        System.out.println(helloOptional
                .map(String::toUpperCase)
                .orElse("world"));

        helloOptional
                .map(String::toUpperCase)
                .orElseGet(() -> defaultString.get());

        helloOptional = Optional.of("hello");

        helloOptional
                .ifPresent(word -> System.out.println(word + ", world!"));

        helloOptional
                .ifPresentOrElse(System.out::println, () -> System.out.println("world!"));

        Person newPerson = new Person("James", "some@email.com");
        var email = newPerson.getEmail().map(String::toUpperCase).orElse("No Email Provided");
        System.out.println(email);
      /*
        But if we make the email null then it will run into nullPointerException.
        To remove this we make the getString return an optional value. and we can check the returned optional value
        here.
      */
    }

    static Supplier<String> defaultString = () -> "defaultString";
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
