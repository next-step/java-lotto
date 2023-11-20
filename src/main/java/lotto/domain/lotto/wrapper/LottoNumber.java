package lotto.domain.lotto.wrapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final List<LottoNumber> numbers = IntStream.rangeClosed(MIN, MAX)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toUnmodifiableList());

    private final int number;

    private LottoNumber(int number) {
        validateRange(number);

        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(numbers.get(number - MIN))
            .orElseThrow(() -> new IllegalArgumentException(String.format("숫자의 범위는 %d ~ %d입니다.", MIN, MAX)));
    }

    private static void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(String.format("숫자의 범위는 %d ~ %d입니다.", MIN, MAX));
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MIN || number > MAX;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}

