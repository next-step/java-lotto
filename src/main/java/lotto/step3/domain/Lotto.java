package lotto.step3.domain;

import java.util.Set;

public class Lotto extends ValidateNumbers {
    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        this.lotto = validateNumbers(lotto);
    }

    public Set<Integer> getLotto() {
        return Set.copyOf(lotto);
    }


}
