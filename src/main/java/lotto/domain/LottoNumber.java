package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int SAVED_MIN_NUMBER = 1;
    public static final int SAVED_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE = "로또 번호는 1이상 45이하의 수만 들어올 수 있다.";

    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);

        this.number = number;
    }

    private static void checkNumberRange(int number) {
        if (!isNumberRange(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isNumberRange(int num) {
        return num >= SAVED_MIN_NUMBER && num <= SAVED_MAX_NUMBER;
    }

    public static List<LottoNumber> generateNumbers(String[] inputs) {
        return Arrays.stream(inputs)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

}
