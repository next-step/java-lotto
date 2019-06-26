package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.NoSuchLottoException;

import java.util.Iterator;
import java.util.List;

public class ManualLottoGenerator extends PaymentLottoGenerator {

    private final Iterator<Lotto> lottos;

    ManualLottoGenerator(final List<Lotto> lottos) {
        this.lottos = lottos.iterator();
    }

    ManualLottoGenerator(final LottoTicket lottoTicket) {
        this(lottoTicket.getLottos());
    }

    @Override
    protected Lotto generate() {
        if (!hasNext()) {
            throw new NoSuchLottoException();
        }

        return lottos.next();
    }

    private boolean hasNext() {
        return lottos.hasNext();
    }
}
