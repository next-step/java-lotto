package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .mapToObj(idx -> lottoNumberMap.put(idx, new LottoNumber(idx)));
    }

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
    }

    public static int getStartNumber() {
        return MIN_NUMBER;
    }

    public static int getLastNumber() {
        return MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return MIN_NUMBER == that.MIN_NUMBER && MAX_NUMBER == that.MAX_NUMBER && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_NUMBER, MAX_NUMBER, number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
