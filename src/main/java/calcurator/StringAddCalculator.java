package calcurator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input)) return Const.INITIAL_NUMBER_ZERO;
        if (input.length() == Const.STRING_LENGTH_NUM_ONE) {
            return Integer.parseInt(input);
        }
        return splitCommaAndSum(input);
    }

    private static int splitCommaAndSum(String input) {
        AtomicInteger sumNumber = new AtomicInteger();
        Arrays.stream(input.split(Const.SYMBOL_COMMA)).forEach(numberString ->
                sumNumber.addAndGet(Integer.parseInt(numberString))
        );
        return sumNumber.get();
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
