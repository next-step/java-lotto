package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Number> lotto;

    private Lotto(final List<Number> lotto) {

        this.lotto = lotto;
    }

    public static Lotto from(final List<Integer> lottoNumber) {

        return new Lotto(convert(lottoNumber));
    }

    private static List<Number> convert(final List<Integer> numbers) {

        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getLotto() {

        return Collections.unmodifiableList(this.lotto);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
