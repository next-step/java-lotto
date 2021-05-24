package stringaddcalculator;

import java.util.List;
import java.util.regex.Matcher;

public class StringAddCalculator {
    private static InputHandler inputHandler = new InputHandler();

    public static int splitAndSum(String input) {
        if (inputHandler.isEmptyInput(input)) {
            return 0;
        }
        Divider divider = new Divider(input);
        String expression = divider.expression();
        String[] numArray = divider.getDividedInput(expression);
        return stringAdd(numArray);
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
