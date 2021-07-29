package lotto.domain.lotto;


import lotto.domain.money.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.money.Money.LOWEST_AMOUNT;

public class LottoOffice {
    private static final Money LOTTO_PRICE_OF_SINGLE = Money.of(LOWEST_AMOUNT);
    private final Money money;

    private LottoOffice(Money money) {
        this.money = money;
    }

    public static LottoOffice of(Money money) {
        return new LottoOffice(money);
    }
    
    public LottoBunch purchase() {
        List<Lotto> lottos = Stream.generate(LottoGenerator::generate)
                .map(Lotto::of)
                .limit(money.getPurchasableQuantity(LOTTO_PRICE_OF_SINGLE))
                .collect(Collectors.toList());

        return LottoBunch.of(lottos);
    }

}
