package CombinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static CombinatorPattern.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail()
                .matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
                ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneValid () {
        return customer -> customer.getPhoneNumber()
                .matches("(0/91)?[7-9][0-9]{9}")
                ? SUCCESS : PHONE_NUMBER_NOT_VALID ;
    }

    static CustomerRegistrationValidator isAnAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18
                ? SUCCESS : IS_NOT_AN_ADULT ;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

}
enum ValidationResult {
    // successful validation
    SUCCESS,

    // phone number is invalid.
    PHONE_NUMBER_NOT_VALID,

    // email ID is invalid
    EMAIL_NOT_VALID,

    // customer is not an adult.
    IS_NOT_AN_ADULT
}
