package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    private void checkNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 숫자는 " + MIN + "과 " + MAX + " 사이의 값이어야 합니다");
        }
    }

    public static List<LottoNumber> buildAllLottoNumbers() {
        return IntStream.rangeClosed(MIN, MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public boolean biggerThan(int number) {
        return this.number > number;
    }

    public boolean biggerThan(LottoNumber lottoNumber) {
        return this.number > lottoNumber.number;
    }

    public boolean smallerThan(int number) {
        return this.number < number;
    }

    public boolean smallerThan(LottoNumber lottoNumber) {
        return this.number < lottoNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        assert o instanceof LottoNumber;
        return number == ((LottoNumber) o).number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}
