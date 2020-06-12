package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    public static final List<LottoNumber> NUMBERS = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자로 구성 되어야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LottoNumber) {
            LottoNumber other = (LottoNumber) o;
            return this.number == other.getNumber();
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber number) {
        return Integer.compare(this.number, number.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
