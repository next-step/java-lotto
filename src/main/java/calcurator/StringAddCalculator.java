package calcurator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input))
            return Const.INITIAL_NUMBER_ZERO;

        if (input.length() == Const.STRING_LENGTH_NUM_ONE) {
            return Integer.parseInt(input);
        }

        return splitSeparatorAndSum(input);
    }

    private static int splitSeparatorAndSum(String input) {
        AtomicInteger sumNumber = new AtomicInteger();
        Arrays.stream(input.split(Const.SYMBOL_COMMA_AND_COLON)).forEach(numberString -> {
            int parseInt = Integer.parseInt(numberString);
            if (parseInt < Const.ZERO_NUM) {
                throw new RuntimeException("양수를 입력해주세요.");
            }
            sumNumber.addAndGet(parseInt);
        });
        return sumNumber.get();
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
