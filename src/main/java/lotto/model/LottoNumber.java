package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<LottoNumber> NUMBER_CACHE = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        validate(number);
        return NUMBER_CACHE.get(number - 1);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 값만 가질 수 있습니다. number: " + number);
        }
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
        return String.valueOf(number);
    }
}
