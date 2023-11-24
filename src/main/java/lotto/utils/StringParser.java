package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {
    public static final String DELIMITER = ",";
    public static final String NUMBER_COMMA_BLANK_ONLY = "^[0-9,\\s]+$";

    public static List<Integer> stringToIntegerList(String input) {
        if (!input.matches(NUMBER_COMMA_BLANK_ONLY)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
        return Stream.of(input.split(DELIMITER)).map(number -> Integer.parseInt(number.trim())).collect(Collectors.toList());
    }
}
