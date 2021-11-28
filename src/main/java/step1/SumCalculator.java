package step1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumCalculator {
    private static final int ZERO = 0;
    private static SumCalculator INSTANCE;

    private SumCalculator() {}

    public static SumCalculator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SumCalculator();
        }
        return INSTANCE;
    }

    public static int sumCalculate(String[] strings) {
        int[] resultInteger = convertStringsToIntegers(strings);

        return IntStream.of(resultInteger).sum();
    }

    private static int[] convertStringsToIntegers(String[] strings) {
        return Arrays.stream(strings)
                .map(text -> convertStringToInt(text))
                .mapToInt(Integer::intValue).toArray();
    }

    private static int convertStringToInt(String text) {
        validParseOrElseThrow(text);

        return Integer.parseInt(text);
    }

    private static void validParseOrElseThrow(String text) {
        try {
            if(Integer.parseInt(text) < ZERO) {
                throw new RuntimeException(MyException.INVALID_NUMBER.getMessage());
            }
        } catch(NumberFormatException e) {
            throw new RuntimeException(MyException.INVALID_NUMBER.getMessage());
        }
    }
}
