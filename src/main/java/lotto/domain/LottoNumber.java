package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final Map<Integer, LottoNumber> LOTTO_NUMBERS = IntStream
            .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toUnmodifiableMap(number -> number, LottoNumber::new));

    private final int value;

    private LottoNumber(final int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }

    public static LottoNumber from(final int value) {
        return Optional.ofNullable(LOTTO_NUMBERS.get(value))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1 이상 45 이하여야 합니다. 번호: " + value));
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return this.value == ((LottoNumber)other).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
