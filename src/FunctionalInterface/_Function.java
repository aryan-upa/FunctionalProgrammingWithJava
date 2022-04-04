package FunctionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int incrementedValue = incrementByOneFunction.apply(1);
        System.out.println(incrementedValue);

        int multipliedValue = multiplyBy10Function.apply(incrementedValue);
        System.out.println(multipliedValue);

        //Now If we want to chain multiple function we can do that using the andThen method.
        Function<Integer, Integer> add1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println("andThen Output\n" + add1AndThenMultiplyBy10.apply(1));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;
    // Function<Input Type, Return Type> functionName = var -> changeInVariable;
    // This is basically a function defined as a variable in the same class in which we want to use it.
    // To give the value to the only parameter we use apply method.
    // These are functional Interface.

    static Function<Integer, Integer> multiplyBy10Function = number -> number*10;


}
