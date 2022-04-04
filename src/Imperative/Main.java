package Imperative;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Aryan", Gender.MALE),
                new Person("Priyanshi", Gender.FEMALE),
                new Person("Arjun", Gender.MALE),
                new Person("Shakti", Gender.FEMALE),
                new Person("Surbhi", Gender.FEMALE)
        );

        // Imperative Approach to select all females
        List<Person> females = new ArrayList<>();

        for (Person person: people) {
            if(person.gender.equals(Gender.FEMALE))
                females.add(person);
        }

        for (Person female : females) {
              System.out.println(female);
        }

        // Declarative Approach
        people.stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .forEach(System.out::println);

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

/*
Comments : Imperative approach is lengthy even when we need to do something so simple
    Also we have to use a lot of code and define various things which costs us time.

    The Declarative approach is much neater and a lo of work can be done with only
    writing a few lines of code.

 */