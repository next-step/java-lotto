package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String INVALID_NUMBER = "유효하지 않은 로또 번호입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static List<LottoNumber> shuffleNumbers() {
        List<LottoNumber> range = IntStream
                .range(MIN_NUMBER, MAX_NUMBER + 1)
                .boxed()
                .map(v -> new LottoNumber(v))
                .collect(Collectors.toList());
        Collections.shuffle(range);

        return range;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) return;

        throw new IllegalArgumentException(INVALID_NUMBER);
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
