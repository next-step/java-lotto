package lotto.domain;

import lotto.exception.IllegalLottoNumberArgumentTypeException;
import lotto.exception.IllegalLottoNumberBoundaryException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class LottoNumber {
    public static final Map<Integer, LottoNumber> ALL_LOTTO_NUMBERS = initializeAllLottoNumbers();
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private int value;

    private LottoNumber(int value) {
        validateLottoNumberBoundary(value);
        this.value = value;
    }

    public static LottoNumber valueOf(int value) {
        validateLottoNumberBoundary(value);
        return ALL_LOTTO_NUMBERS.get(value);
    }

    public static LottoNumber valueOf(String value) {
        validateIllegalCharacter(value);

        int parsedValue = parseInt(value);
        validateLottoNumberBoundary(parsedValue);

        return ALL_LOTTO_NUMBERS.get(parsedValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toString() {
        return String.valueOf(value);
    }

    private static void validateLottoNumberBoundary(int value) {
        if (MIN_LOTTO_NUMBER > value || value > MAX_LOTTO_NUMBER) {
            throw new IllegalLottoNumberBoundaryException();
        }
    }

    private static void validateIllegalCharacter(String value) {
        try {
            parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalLottoNumberArgumentTypeException();
        }
    }

    private static Map<Integer, LottoNumber> initializeAllLottoNumbers() {
        Map<Integer, LottoNumber> result = new HashMap<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            result.put(i, new LottoNumber(i));
        }

        return result;
    }
}
