package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    private static String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";;
    private static String CANNOT_USE_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 넣을수 없습니다.";

    static boolean isEmpty(Input input) {
        return input.isEmpty();
    }

    static String[] split(Input input) {
        return input.split();
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

    public static int add(Input input) {
        if (isEmpty(input)) return 0;
        return Stream.of(split(input))
                .mapToInt(StringCalculator::parse)
                .reduce(0, Integer::sum);
    }
}
