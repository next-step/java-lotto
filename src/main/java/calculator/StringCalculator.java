package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    public static int add(final Input input) {
        if (input.isEmpty()) return 0;
        return Stream.of(input.split())
                .mapToInt(str -> StringCalculator.parse(new StringNumber(str)))
                .reduce(0, Integer::sum);
    }

    static boolean isEmpty(final Input input) {
        return input.isEmpty();
    }

    static String[] split(final Input input) {
        return input.split();
    }

    static int parse(final StringNumber stringNumber) {
        return stringNumber.parse();
    }
}
