package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator(){};

    public static int splitAndSum(String calculationText) {
        return calculate(new CalculationText().divide(calculationText));
    }

    private static int calculate(String[] calculationText) {

        int calculationNumber = 0;
        if (calculationText.length == 1) {
            return Integer.parseInt(calculationText[0]);
        }

        for(String number : calculationText) {
            calculationNumber += validateNegative(Integer.parseInt(number));
        }

        return calculationNumber;
    }

    private static int validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 사용 불가");
        }
        return number;
    }


}
