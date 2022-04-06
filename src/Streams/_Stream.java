package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("Aryan", Gender.MALE),
            new Person("Priyanshi", Gender.FEMALE),
            new Person("Arjun", Gender.MALE),
            new Person("Shakti", Gender.FEMALE),
            new Person("Surbhi", Gender.FEMALE)
        );

        ArrayList<Integer> lengths = new ArrayList<>();

        people.stream()
                .map(person -> person.name)
                // Maps the certain values to other values
                .mapToInt(String::length)
                // maps the input to output after using the function on it whose RT is integer
                .forEach(lengths::add);
                // does some operation on each of the resulting value.

        System.out.println(lengths);

        System.out.println(people.stream()
                .allMatch(person -> person.gender.equals(Gender.MALE)));
        // Prints whether all the entries in the person follows the predicate condition.

        System.out.println(people.stream()
                .anyMatch(person -> person.gender.equals(Gender.MALE)));
        // Prints whether there is any entry which follows the predicate condition.




    }
    record Person(String name, Gender gender) {
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
