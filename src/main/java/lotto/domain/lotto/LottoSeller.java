package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;

public class LottoSeller {
    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoTicket buy(Price price) {
        return new LottoTicket(price.getLottoCount(), this.generator);
    }
}
