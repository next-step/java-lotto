package accumulate;

import java.util.Arrays;

public class Accumulator {
    private final static String NUMBER_REGEX = "^[0-9]*";
    private final static int ZERO = 0;
    
    public static int accumulate(final String[] numbers) {
        if (Arrays.stream(numbers).anyMatch(number -> !isSignedNumeric(number))) {
            throw new RuntimeException(ErrorMessage.INCORRECT_VALUE.getMessage());
        }
        return Arrays.stream(numbers)
          .mapToInt(number -> Integer.parseInt(number))
          .reduce((number1, number2) -> number1 += number2)
          .orElseThrow(() -> new RuntimeException(ErrorMessage.INCORRECT_VALUE.getMessage()));
    }
    
    private static boolean isSignedNumeric(final String number) {
        return number.matches(NUMBER_REGEX);
    }
}
