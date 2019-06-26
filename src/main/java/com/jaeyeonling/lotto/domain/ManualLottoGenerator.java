package com.jaeyeonling.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Lotto> lottos;

    ManualLottoGenerator(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    ManualLottoGenerator(final LottoTicket lottoTicket) {
        this(lottoTicket.getLottos());
    }

    @Override
    public Lotto generate() {
        return null;
    }
}
