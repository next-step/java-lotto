package stringCalculator.controller;

import java.util.Arrays;

public class Validator {

    public static void validatePositiveNum(String[] equations) throws RuntimeException {
        if (Arrays.stream(equations).map(Integer::parseInt).anyMatch(equation -> equation < 0)) {
            throw new NumberFormatException();
        }
    }
}
