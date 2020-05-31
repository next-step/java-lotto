package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.number.LottoNumber;

public class LottoSeller {
    private final NumberGenerator<LottoNumber> generator;

    public LottoSeller(NumberGenerator<LottoNumber> generator) {
        this.generator = generator;
    }

    public LottoTicket buy(Price price) {
        return new LottoTicket(price.getLottoCount(), this.generator);
    }
}
