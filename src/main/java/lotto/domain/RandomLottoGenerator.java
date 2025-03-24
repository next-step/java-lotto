package lotto.domain;

import java.util.Set;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return new Lotto(Set.of(1, 2, 3, 4, 5, 6));
    }
}
