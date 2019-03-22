package lotto.domain;

import lotto.vo.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    public static final Money LOTTO_PRICE = new Money(1_000);

    private LottoMachine() {
    }

    public static LottoBundle buyLottos(Money money) {
        if (LOTTO_PRICE.isLargerThan(money)) {
            throw new IllegalArgumentException("Input money must be more than " + LOTTO_PRICE.getAmount());
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    static LottoBundle getLottos(long numberOfLotto) {
        List<Lotto> lottos = LongStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    private static long getNumberOfAffordableLottos(Money money) {
        return money.getAmount() / LOTTO_PRICE.getAmount();
    }
}
