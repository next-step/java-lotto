package lotto.factory;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersFactory {
    private static final int LOTTO_AMOUNT = 6;

    private WinningNumbersFactory() {
        throw new AssertionError();
    }

    public static List<Integer> get(String number) {
        String[] numberArray = number.split(",");

        if (numberArray.length != LOTTO_AMOUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 숫자로 이루어져 있습니다.");
        }

        for (String numberString : numberArray) {
            validateNumberRange(numberString);
        }

        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : numberArray) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    private static void validateNumberRange(String numberString) {
        int integer = Integer.parseInt(numberString);
        if (integer < 1 || integer > 45) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }
}
