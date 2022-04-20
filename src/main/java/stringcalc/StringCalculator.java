package stringcalc;

import java.util.Objects;

public class StringCalculator {

    private static final String oddRegex = "$^[+-x%]";
    private static final String evenRegex = "$^[0-9]";

    public int execute(String stringForCalculation) {
        if (stringForCalculation == null || stringForCalculation.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 문자열");
        }

        String[] splitString = stringForCalculation.split(" ");

        if (splitString.length % 2 == 0) {
            throw new IllegalArgumentException("유효하지 않은 문자열");
        }

        int integer;
        int processNumber = Integer.parseInt(splitString[0]);
        for (int i = 1; i < splitString.length; ++i) {
            String string = splitString[i];

            validateArithmeticOperation(string);
            integer = Integer.parseInt(splitString[++i]);

            if ("+".equals(string)) {
                processNumber += integer;
            } else if ("-".equals(string)) {
                processNumber -= integer;
            } else if ("*".equals(string)) {
                processNumber *= integer;
            } else if ("/".equals(string)) {
                processNumber /= integer;
            }
        }

        return processNumber;
    }

    private boolean validateArithmeticOperation(String string) {
//        if (!string.matches(evenRegex)) {
//            throw new IllegalArgumentException("유효하지 않은 사칙연산");
//        }

        return true;
    }
}
