package CombinatorPattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer (
                "Aryan",
                "aryan@gmail.com",
                "9512345678",
                // not mine so call at your own risk
                LocalDate.of(2000,11,20)
        );

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isAnAdult())
                .and(CustomerRegistrationValidator.isPhoneValid())
                .apply(customer);

        if(result != ValidationResult.SUCCESS)
            System.out.println("Not Successful due to " + result.name());
        else
            System.out.println("The Customer \"" + customer.getName() + "\" has been verified successfully!");
    }
}
