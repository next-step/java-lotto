package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String INPUT_DELIMITOR = "[,:]";
    private static final Pattern CUSTOM_INPUT_DELIMITOR = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String input){
        if(!InputValidator.validationInputString(input)) return 0;
        return calculate(splitInputToNumberArr(input));
    }

    public static int calculate(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            sum += InputValidator.validationNumbersNegative(Integer.parseInt(number));
        }
        return sum;
    }

    public static String[] splitInputToNumberArr(String input) {
        Matcher m = CUSTOM_INPUT_DELIMITOR.matcher(input);

        if (m.find()) {
            return split(m.group(1), m.group(2));
        }
        return split(INPUT_DELIMITOR, input);
    }

    private static String[] split(String delimiter, String expression) {
        String[] sArr = expression.split(delimiter);
        return sArr;
    }
}
