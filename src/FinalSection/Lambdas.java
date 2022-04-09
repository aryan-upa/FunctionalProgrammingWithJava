// Introduction to Lambdas.

package FinalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    static Function<Integer, Integer> factorial = value -> {
        if(value == 1 || value == 0)
            return 1;
        return value * Lambdas.factorial.apply(value - 1);
    };
    // we can even make recursive functional Interfaces like this.


    public static void main(String[] args) {
        Function<String,  String> upperCase = String::toUpperCase;
        // using method reference in place of lambda.

        System.out.println(factorial.apply(5));

        BiFunction<Integer, Integer, Integer> addition10Times = (num1, num2) -> {
            num1*=10; num2*=10;
            return num1 + num2;
        };
        // this is a biFunction lambda having multiple line of codes.

        System.out.println(addition10Times.apply(1,2));
    }

}
