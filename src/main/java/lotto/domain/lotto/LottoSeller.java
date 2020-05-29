package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoTicket buy(int price) {
        int lottoCount = price / LOTTO_PRICE;
        return new LottoTicket(lottoCount, this.generator);
    }
}
