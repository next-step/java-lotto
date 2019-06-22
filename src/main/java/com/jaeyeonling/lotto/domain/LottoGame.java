package com.jaeyeonling.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final LottoGenerator lottoGenerator;

    LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buy(final Money money) {
        final List<Lotto> lottos = new ArrayList<>();

        return lottos;
    }
}
