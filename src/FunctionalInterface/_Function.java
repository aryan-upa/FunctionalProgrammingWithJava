package FunctionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int incrementedValue = incrementByOneFunction.apply(1);
        System.out.println(incrementedValue);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number++;
    // Function<Input Type, Return Type> functionName = var -> changeInVariable;
    // This is basically a function defined as a variable in the same class in which we want to use it.
    // To give the value to the only parameter we use apply method.
    // These are functional Interface.

}
