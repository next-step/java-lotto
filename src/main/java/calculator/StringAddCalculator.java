package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String delimeter = ",|:";
;
    public static int splitAndSum(String calculationText) {
        if (validate(calculationText)) {
            return 0;
        }
        return calculate(calculationText);
    }

    private static boolean validate(String calculationText) {
        return calculationText == null || calculationText.isEmpty();
    }

    private static int calculate(String calculationText) {

        String[] numbers = calculationTextSplit(calculationText);
        int calculationNumber = 0;

        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }

        for(String number : numbers) {
            calculationNumber += validateNegative(Integer.parseInt(number));
        }

        return calculationNumber;
    }

    private static String[] calculationTextSplit(String calculationText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calculationText);
        if (m.find()) {
            delimeter += "|" + m.group(1);
            return  m.group(2).split(delimeter);
        }
        return calculationText.split(delimeter);
    }

    private static int validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 사용 불가");
        }
        return number;
    }


}
