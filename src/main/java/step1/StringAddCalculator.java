package step1;

import static step1.Constants.COMMA;
import static step1.Constants.COLON;

public class StringAddCalculator {

    public static int splitAndSum(String numberString) {
        if (!validateText(numberString)) {
            return 0;
        }

        int addParsedNumberString = addParsedNumberString(parseNumberString(numberString));

        return addParsedNumberString;
    }

    private static Boolean validateText(String numberString) {
        if (numberString == null) {
            return false;
        }

        if (numberString.isEmpty()) {
            return false;
        }

        return true;
    }

    private static String[] parseNumberString(String numberString) {
        String tokenPattern = COMMA + "|" + COLON;
        String[] numbers = numberString.split(tokenPattern);
        return numbers;
    }

    private static int addParsedNumberString(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
