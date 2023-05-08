package lotto.step4.domain;

import java.util.Set;
import java.util.TreeSet;

public class Lotto extends ValidateNumbers {
    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        this.lotto = validateNumbers(lotto);
    }

    public Set<Integer> getLotto() {
        return new TreeSet<>(Set.copyOf(lotto));
    }


}
