package edu.nextstep.camp.lotto.domain;

import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {
    private static final LottoGenerator instance = new FixedLottoGenerator();

    public static LottoGenerator getInstance() {
        return instance;
    }

    @Override
    public Lotto generate() {
        return Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));
    }
}
