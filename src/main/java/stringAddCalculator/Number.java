package stringAddCalculator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Number {
    public final static int ZERO = 0;

    public static int numbers(String[] inputs) {
        return sumNumbers(putStringToInt(inputs));
    }

    private static int[] putStringToInt(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int sumNumbers(int[] numbers) {
        isPositiveNumber(numbers);
        return Arrays.stream(numbers).sum();
    }

    private static void isPositiveNumber(int[] numbers){
        Arrays.stream(numbers)
                .filter(number -> number < ZERO)
                .findAny()
                .ifPresent(number -> {throw new RuntimeException();});
    }
}
