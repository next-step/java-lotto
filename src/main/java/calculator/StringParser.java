package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String NUMBER_CHECK_REGEX = "-[0-9]*|[\\D]*";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public List<Integer> getNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (isNullOrEmpty(input)) {
            return numbers;
        }

        String[] splits = getSplitsString(input);
        for (String split : splits) {
            numbers.add(toInteger(split));
        }
        return numbers;
    }

    private String[] getSplitsString(String input) {
        negativeOrNotNumberCheck(input);

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private void negativeOrNotNumberCheck(String input) {
        if (input.matches(NUMBER_CHECK_REGEX)) {
            throw new IllegalArgumentException("음수를 제외한 숫자 외 다른 문자를 입력할 수 없습니다.");
        }
    }

    private int toInteger(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없는 문자열입니다. -> " + input);
            e.printStackTrace();
        }
        return number;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.replaceAll(" ", "").isEmpty();
    }
}
