package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private static final int LOTTO_PRICE = 1000;

    private Shop() {}

    public static Lottos buyLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        return (Lottos) Stream.generate(() -> new Lotto()).limit(lottoCount).collect(Collectors.toList());
    }
}
