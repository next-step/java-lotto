package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private final Set<Integer> lottoNumbers;

    public Lotto(final Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(final int... numbers) {
        this(new HashSet<>(Arrays.asList(
                Arrays.stream(numbers)
                        .boxed()
                        .toArray(Integer[]::new))));
    }

    public Lotto(final String numbers) {
        this(
                Arrays.stream(numbers.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}
