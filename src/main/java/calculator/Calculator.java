package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String DELIMITER = ",|:";

    public static int calculate(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        String[] splitInput;

        if(m.find()) {
            String customDelimiter = m.group(1);
            splitInput = m.group(2).split(customDelimiter);
        } else {
            splitInput = input.split(DELIMITER);
        }

        int sum = 0;

        for (String s : splitInput) {

            boolean matches = s.matches("[+-]?\\d*(\\.\\d+)?");

            if(!matches) {
                 throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
            }

            int parsedInt = Integer.parseInt(s);

            if(parsedInt < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }

            sum += parsedInt;
        }

        return sum;
    }
}
