package stringAddCalculator;

import java.util.Arrays;

public class Number {
    public final static int ZERO = 0;

    public static int addStringCalculate(String[] inputs) {
        return sumNumbers(putStringToInt(inputs));
    }

    private static int[] putStringToInt(String[] inputs) {
        Arrays.stream(inputs)
                .forEach(input -> isPositiveNumber(input));

        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static void isPositiveNumber(String input){
        if(Integer.parseInt(input) < ZERO) {
            throw new RuntimeException();
        }
    }
}
