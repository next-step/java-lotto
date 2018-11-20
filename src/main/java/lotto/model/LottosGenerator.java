package lotto.model;

import lotto.LottoConstants;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);

    default Money moneyOfCount(int count) {
        return Money.from(count * LottoConstants.PRICE_PER_ONE);
    }
}
