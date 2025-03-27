package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculatorParser {
    private static final Pattern stringPattern = Pattern.compile("\\d( [+\\-*/] \\d)+");

    public static StringCalculator parse(String input) {
        if (input == null || input.isEmpty() || !stringPattern.matcher(input).find())
            throw new IllegalArgumentException("Invalid input");

        return new StringCalculator(Arrays.stream(input.split(" ")).collect(Collectors.toCollection(LinkedList::new)));
    }
}
