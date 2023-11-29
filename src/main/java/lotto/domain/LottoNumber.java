package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> RANGE_LOTTO_NUMBER_MAP =
            IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                    .boxed()
                    .map(LottoNumber::new)
                    .collect(Collectors.toMap(LottoNumber::toInt, Function.identity()));

    private final int number;

    private LottoNumber(int input) {
        validateNumber(input);
        this.number = input;
    }

    public static LottoNumber Of(int number) {
        return RANGE_LOTTO_NUMBER_MAP.getOrDefault(number, new LottoNumber((number)));
    }

    private int toInt() {
        return this.number;
    }

    private void validateNumber(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d부터 %d사이의 숫자여야합니다 : %d", MIN_NUMBER, MAX_NUMBER, input));
        }
    }

    @Override
    public int compareTo(LottoNumber target) {
        return Integer.compare(this.number, target.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
