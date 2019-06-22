import java.util.Arrays;
import java.util.regex.Pattern;

public class Accumulator {
    private final static String NUMBER_REGEX = "^[0-9]*";
    private final static int ZERO = 0;
    
    public static int accumulate(final int[] numbers) {
        if (Arrays.stream(numbers).anyMatch(number -> number < ZERO)) {
            throw new RuntimeException(ErrorMessage.INCORRECT_VALUE.getMessage());
        }
        return Arrays.stream(numbers)
            .reduce((number1, number2) -> number1 += number2)
            .getAsInt();
    }
    
    public static int accumulate(final String[] numbers) {
        if (Arrays.stream(numbers).anyMatch(number -> !isNumeric(number))) {
            throw new RuntimeException(ErrorMessage.INCORRECT_VALUE.getMessage());
        }
        return accumulate(Arrays.stream(numbers).mapToInt(number -> Integer.parseInt(number)).toArray());
    }
    
    private static boolean isNumeric(final String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).find();
    }
}
