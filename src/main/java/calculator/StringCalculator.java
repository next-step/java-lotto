package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private static String DEFAULT_DELIMITER = "[,:]";
    private static String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";;
    private static String CANNOT_USE_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 넣을수 없습니다.";

    static boolean isEmpty(String input) {
        return null == input || "".equals(input.trim());
    }

    static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    static int parse(String stringNumber) {
        int result = 0;
        try {
            result = Integer.valueOf(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_A_NUMBER_EXCEPTION_MESSAGE);
        }

        if (result < 0) throw new RuntimeException(CANNOT_USE_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        return result;
    }

    public static int add(String input) {
        if (isEmpty(input)) return 0;
        return Stream.of(split(input))
                .mapToInt(StringCalculator::parse)
                .reduce(0, Integer::sum);
    }
}
