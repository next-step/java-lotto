package com.jaeyeonling.lotto.domain;

import java.util.Iterator;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private final Iterator<Lotto> lottos;

    ManualLottoGenerator(final List<Lotto> lottos) {
        this.lottos = lottos.iterator();
    }

    @Override
    public Lotto generate() {
        return lottos.next();
    }
}
