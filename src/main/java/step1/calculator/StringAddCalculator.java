package step1.calculator;

/**
 * .
 */
public class StringAddCalculator {

    public static int splitAndSum(String inputString) {
        return ValidateString.available(inputString) ?
                Delimiter.of(inputString).convertToNumbers(inputString).sum() : 0;
    }
}
