package stringAddCalculator;

import java.util.List;

public class StringAddCalculator {
    private static InputHandler inputHandler = new InputHandler();

    public static int splitAndSum(String input) {
        return 0;
    }

    private static int stringAdd(String[] numArray) {
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            inputHandler.illegalInputFilter(numArray[i]);
            sum += Integer.parseInt(numArray[i]);
        }
        return sum;
    }
}
