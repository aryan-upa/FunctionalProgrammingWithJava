package Optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "defaultValue");

        System.out.println(value);

        Object value2 = Optional.ofNullable("HelloAgain")
                .orElseThrow(() -> new IllegalArgumentException("WTH bro!"));

        System.out.println(value2);

        Optional.ofNullable("HelloTheFinal")
                .ifPresentOrElse(System.out::println, () -> System.out.println("Again bro, really!"));

        Optional.ofNullable("aryan@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to : " + email)
                        , () -> System.out.println("No Email provided"));


    }
}
