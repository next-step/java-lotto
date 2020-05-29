package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;

public class LottoSeller {
    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoTicket buy(int price) {
        return new LottoTicket(new Price(price).getLottoCount(), this.generator);
    }
}
