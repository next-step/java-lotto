package lotto.domain;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoBundle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1_000;
    public static final int MINIMUM_INPUT_MONEY = 0;

    private LottoMachine() {
    }

    public static LottoBundle buyLottos(long money) {
        if (money < MINIMUM_INPUT_MONEY) {
            throw new IllegalArgumentException("money must be positive");
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    static LottoBundle getLottos(long numberOfLotto) {
        List<Lotto> lottos = LongStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    public static long getNumberOfAffordableLottos(long money) {
        return money / LOTTO_PRICE;
    }
}
