package step3.model;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean checkNum(int num) {
        return this.lotto.contains(num);
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(this.lotto, lotto.getLotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lotto);
    }
}
