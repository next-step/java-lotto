package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private static final int LOTTO_PRICE = 1_000;

    private Shop() {}

    public static List<Lotto> buyLottos(Long money) {
        long lottoCount = money / LOTTO_PRICE;
        return Stream.generate(() -> new Lotto())
                .limit(lottoCount)
                .collect(Collectors.toList());
    }
}
