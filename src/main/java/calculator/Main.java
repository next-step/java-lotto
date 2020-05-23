package calculator;


import calculator.domain.splitter.CommaAndColonSplitter;
import calculator.domain.splitter.CustomSplitter;
import calculator.domain.splitter.Splitter;

import java.util.Arrays;

public class Main {
    private static final int ZERO = 0;

    public int calculate(String input) {

        if (emptyCheck(input)) {
            return ZERO;
        }

        String[] splitInput = split(input);

        return 0;
    }

    private static boolean emptyCheck(String input) {
        return input == null || input.isEmpty();
    }

    private String[] split(String input) {
        Splitter customSplitter = new CustomSplitter();

        if (customSplitter.isSupport(input)) {
            return customSplitter.split(input);
        }

        Splitter commaAndColonSplitter = new CommaAndColonSplitter();

        return commaAndColonSplitter.split(input);
    }
}
