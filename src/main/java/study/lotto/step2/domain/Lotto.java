package study.lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> selectedNumbers;

    public Lotto(List<Integer> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(selectedNumbers, lotto.selectedNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectedNumbers);
    }
}
