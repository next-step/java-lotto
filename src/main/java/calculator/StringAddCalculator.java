package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String formula) {
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers(formula);
        return calculatingNumbers.sum();
    }
}
