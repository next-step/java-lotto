package step1;

import static step1.ErrorMessages.SHOULD_BE_NUMBER;
import static step1.ErrorMessages.SHOULD_NOT_NEGATIVE_NUMBER;
import static step1.StringNumbersParser.parseNumberString;

public class StringAddCalculator {

    public static int splitAndSum(String numberString) {
        if (!validateText(numberString)) {
            return 0;
        }
        int result = Integer.parseInt(numberString);

        return addParsedNumberString(parseNumberString(numberString));
    }

    private static Boolean validateText(String numberString) {
        if (numberString == null || numberString.isEmpty()) {
            return false;
        }

        return true;
    }

    private static int addParsedNumberString(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += convertStringToInt(number);
        }
        return result;
    }

    private static int convertStringToInt(String number) {
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(SHOULD_BE_NUMBER);
        }

        if (value < 0) {
            throw new RuntimeException(SHOULD_NOT_NEGATIVE_NUMBER);
        }
        return value;
    }
}
