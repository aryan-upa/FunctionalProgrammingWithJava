package CombinatorPattern;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = LocalDate.of(1999,1,1);
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = "not@generated.com";
        this.dob = LocalDate.of(1999,1,1);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }
}
