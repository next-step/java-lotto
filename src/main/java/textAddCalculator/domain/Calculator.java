package textAddCalculator.domain;

import textAddCalculator.utils.Splitter;

import java.util.Arrays;

import static textAddCalculator.utils.ValidationChecker.exceptionCheck;
import static textAddCalculator.utils.ValidationChecker.isEmptyOrNull;

public class Calculator {
    private static final String ZERO = "0";

    public int splitAndSum(String text) {
        String[] numArr = Splitter.split(!isEmptyOrNull(text) ? text : ZERO);
        exceptionCheck(numArr);
        return Arrays.stream(numArr).mapToInt(Integer::parseInt).sum();
    }
}
