package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    public static final int PRICE_OF_LOTTO = 1_000;
    public static final int MIN_MONEY = 0;

    private LottoMachine() {
    }

    static LottoBundle getLottos(long numberOfLotto) {
        List<Lotto> lottos = LongStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    public static LottoBundle buyLottos(long money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException("money must be positive");
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    public static long getNumberOfAffordableLottos(long money) {
        return money / PRICE_OF_LOTTO;
    }
}
