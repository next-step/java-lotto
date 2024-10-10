package lotto.domain;

import java.util.Set;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public Set<Integer> generateNumbers() {
        return Set.of(1, 2, 3, 4, 5, 6);
    }
}
