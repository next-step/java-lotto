package calcurator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class StringAddCalculator {
    private static final int INITIAL_NUMBER_ZERO = 0;

    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input))
            return INITIAL_NUMBER_ZERO;

        return addSum(Splitter.split(input));
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }

    private static int addSum(String[] inputs) {
        AtomicInteger sumNumber = new AtomicInteger();
        Arrays.stream(inputs).forEach(numberString -> {
            int parseInt = Integer.parseInt(numberString);
            if (parseInt < INITIAL_NUMBER_ZERO) {
                throw new RuntimeException("양수를 입력해주세요.");
            }
            sumNumber.addAndGet(parseInt);
        });
        return sumNumber.get();
    }
}
