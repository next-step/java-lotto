package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int PRICE_OF_LOTTO = 1_000;

    private LottoMachine() {
    }

    static List<Lotto> getLottos(int numberOfLotto) {
        return IntStream.range(0, numberOfLotto)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());
    }

    public static List<Lotto> buyLottos(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }

        return getLottos(getNumberOfAffordableLottos(money));
    }

    private static int getNumberOfAffordableLottos(int money) {
        return money / PRICE_OF_LOTTO;
    }
}
