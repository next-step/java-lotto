package calculator;

import calculator.to.StringSumCalculatorInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("(//(.)\n)?(.*)");
    public static StringSumCalculatorInput parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if(matcher.matches()){
            return new StringSumCalculatorInput.Builder()
                    .delimiter(matcher.group(2))
                    .parameters(matcher.group(3))
                    .build();
        }
        throw new IllegalArgumentException("invalid input to parse");
    }
}
