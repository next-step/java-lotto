package step2.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Number {

    private static final Pattern patternNumbersOnly = Pattern.compile("^[-+]?[0-9]+$");

    public static void checkNumber(String inputString) {
        if (!patternNumbersOnly.matcher(inputString).matches()) {
            throw new IllegalArgumentException("Found a not number(s)");
        }
    }

    public static void checkNumber(String[] inputString) {
        Arrays.stream(inputString)
                .forEach(string -> {
                            if (!patternNumbersOnly.matcher(string).matches()) {
                                throw new IllegalArgumentException("Found a not number(s)");
                            }
                        }
                );
    }

    public static void checkNotNumber(String number) {

        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("Found a negative number(s)");
        }

    }

    public static void checkNotNumber(String[] numbers) {

        // find a negative number(s).
        if (Arrays.stream(numbers)
                .map(Integer::parseInt)
                .filter(number -> number < 0)
                .count() > 0) {
            throw new IllegalArgumentException("Found a negative number(s)");
        }

    }

    public static int getGameCountByPayMoney(int payMoney, int goodsPrice) {
        if (payMoney <= 0 || payMoney % goodsPrice != 0) {
            throw new IllegalArgumentException();
        }
        return payMoney / goodsPrice;
    }
}
