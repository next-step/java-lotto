package calcalator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",";

    public static boolean isEmpty(String input) {
        return input == null || "".equals(input);
    }

    public static int parse(String input) throws NumberFormatException {
        if (isEmpty(input))
            return 0;

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("구분자 외 숫자 이외의 값은 전달할 수 없습니다.");
        }

        if (number < 0) {
            throw new RuntimeException("입력값으로 음수는 전달할 수 없습니다.");
        }
        return number;
    }

    public static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split("");
    }

    public static int plus(String input, String delimiter) {

        String[] inputSplit = split(input, delimiter);
        int[] numbers = Arrays.stream(inputSplit)
                .mapToInt(Calculator::parse)
                .toArray();

        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    public static int plus(String input) {
        String[] inputSplit = split(input);
        int[] numbers = Arrays.stream(inputSplit)
                .mapToInt(Calculator::parse)
                .toArray();

        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
