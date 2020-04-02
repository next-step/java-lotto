package lotto.model.wrapper;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> NUMBERS;

    private final int number;

    static {
        NUMBERS = Collections.unmodifiableMap(IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new)));
    }

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        return Optional.ofNullable(NUMBERS.get(number))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1 이상, 45 이하여야 합니다."));
    }

    public static LottoNumber of(final String number) {
        return of(Integer.parseInt(number));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
