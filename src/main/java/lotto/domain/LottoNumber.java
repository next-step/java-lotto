package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);

        this.number = number;
    }

    private static void validateNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber valueOf(int value) {
        validateNumber(value);
        Collections.sort(lottoNumbers, Comparator.comparingInt(LottoNumber::getNumber));
        return lottoNumbers.get(toIndex(value));
    }

    private static int toIndex(int value) {
        return value - ONE;
    }

    public static LottoNumber peek() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.get(ZERO);
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
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
