package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.calculator.NonNumericValuesException;
import calculator.domain.calculator.StringCalculator;
import calculator.domain.splitter.CommaAndColonSplitter;
import calculator.domain.splitter.CustomSplitter;
import calculator.domain.splitter.Splitter;

import java.util.Arrays;

public class Main {
    private static final int ZERO = 0;

    public static int calculate(String input) {

        if (emptyCheck(input)) {
            return ZERO;
        }

        String[] splitInput = split(input);
        validateNonNumericValues(splitInput);

        Calculator stringCalculator = new StringCalculator(splitInput);

        return stringCalculator.sum();
    }

    private static boolean emptyCheck(String input) {
        return input == null || input.isEmpty();
    }

    private static void validateNonNumericValues(String[] inputs) {
        Arrays.stream(inputs).forEach(Main::numericCheck);
    }

    private static void numericCheck(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NonNumericValuesException();
        }
    }

    private static String[] split(String input) {
        Splitter customSplitter = new CustomSplitter();

        if (customSplitter.isSupport(input)) {
            return customSplitter.split(input);
        }

        Splitter commaAndColonSplitter = new CommaAndColonSplitter();

        return commaAndColonSplitter.split(input);
    }
}
