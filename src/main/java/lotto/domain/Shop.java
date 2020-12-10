package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private static final int LOTTO_PRICE = 1_000;

    private Shop() {}

    public static Lottos buyLottos(long money) {
        long lottoCount = money / LOTTO_PRICE;
        return new Lottos(Stream.generate(() -> new Lotto(Numbers.getNumbers())).limit(lottoCount).collect(Collectors.toList()));
    }
}
