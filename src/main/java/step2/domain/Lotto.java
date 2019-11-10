package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(final Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(final List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
