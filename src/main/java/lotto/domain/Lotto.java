package lotto.domain;

import java.util.*;

public class Lotto {

    private final List<Number> lotto;

    public Lotto(final List<Number> lotto) {

        this.lotto = lotto;
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
