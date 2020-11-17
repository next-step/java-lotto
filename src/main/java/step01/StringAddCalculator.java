package step01;

import java.util.Arrays;

public class StringAddCalculator {

    public static int calculate(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> {
                    Int.validateNotNegative(a);
                    return a + b;
                });
    }

    public static int splitAndSum(String text) {
        if (BlankValidator.validate(text))
            return 0;

        if (Int.isParsed(text))
            return Integer.parseInt(text);

        String[] numbers = Tokenizer.execute(text);

        return calculate(numbers);
    }
}
