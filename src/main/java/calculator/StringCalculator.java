package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    static boolean isEmpty(Input input) {
        return input.isEmpty();
    }

    static String[] split(Input input) {
        return input.split();
    }

    static int parse(StringNumber stringNumber) {
        return stringNumber.parse();
    }

    public static int add(Input input) {
        if (input.isEmpty()) return 0;
        return Stream.of(input.split())
                .mapToInt(str -> StringCalculator.parse(new StringNumber(str)))
                .reduce(0, Integer::sum);
    }
}
