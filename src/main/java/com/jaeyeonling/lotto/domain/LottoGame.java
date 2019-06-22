package com.jaeyeonling.lotto.domain;

import java.util.List;

public class LottoGame {

    private final LottoGenerator lottoGenerator;

    LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buy() {
        return List.of(lottoGenerator.generate());
    }
}
