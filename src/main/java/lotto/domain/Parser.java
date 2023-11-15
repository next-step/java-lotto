package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String LOTTO_DELIMITER = ",";
    private static final String EMPTY_SPACE = " ";
    public static int numberParsing(String value) {
        return parseNumberFormat(value);
    }
    private static int parseNumberFormat(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다", e);
        }
    }
    public static List<Integer> numbersParsing(String value) {

        value = value.replaceAll(EMPTY_SPACE, "");

        List<Integer> numbers = stringNumbersConversion(stringSplit(value));

        if(numbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개를 입력해야됩니다.");
        }
        return numbers;
    }
    private static List<String> stringSplit(String value) {
        String[] splitText = value.split(LOTTO_DELIMITER);
        return Arrays.asList(splitText);
    }
    private static List<Integer> stringNumbersConversion(List<String> values) {
        List<Integer> numbers = new ArrayList<>();
        for(String value : values) {
            numbers.add(numberParsing(value));
        }
        return numbers;
    }
}
