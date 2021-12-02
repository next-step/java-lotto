package edu.nextstep.camp.lotto.domain;

import static edu.nextstep.camp.lotto.domain.LottoTest.lotto;

public class FixedLottoGenerator implements LottoGenerator {
    private static final LottoGenerator instance = new FixedLottoGenerator();

    public static LottoGenerator getInstance() {
        return instance;
    }

    @Override
    public Lotto generate() {
        return lotto(1, 2, 3, 4, 5, 6);
    }
}
