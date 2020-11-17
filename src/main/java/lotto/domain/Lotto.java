package lotto.domain;

import java.util.Set;

public class Lotto {
    private final Set<Integer> lotto;

    private Lotto(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(LottoGenerator lottoGenerator) {
        return new Lotto(lottoGenerator.create());
    }

    public Set<Integer> getLotto() {
        return this.lotto;
    }
}
