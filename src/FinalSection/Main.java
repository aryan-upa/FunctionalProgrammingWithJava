// using callbacks in java.

package FinalSection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("John", "McCarthy", noLastName);
        hello("Ankit", "", noLastName);
    }

    static void hello(String fName, String lName, Consumer<String> callback) {
        System.out.print(fName + " ");
        if(lName == null || lName.isEmpty())
            callback.accept(fName);
        else
            System.out.println(lName);
    }

    static Consumer<String> noLastName = value -> {
        String output = String.format("\"Err!! No last Name provided for %s.\"", value);
        System.out.println(output);
    };
}
