package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int PRICE_OF_LOTTO = 1_000;

    private LottoMachine() {
    }

    static LottoBundle getLottos(int numberOfLotto) {
        List<Lotto> lottos = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    public static LottoBundle buyLottos(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    public static int getNumberOfAffordableLottos(int money) {
        return money / PRICE_OF_LOTTO;
    }
}
