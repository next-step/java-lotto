package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
    private static final int MINIMUM_QUANTITY = 1;

    public Lottos buyLottos(long price) {
        return IntStream.rangeClosed(MINIMUM_QUANTITY, getLottoCountForBuying(price))
                .mapToObj(count -> Lotto.auto())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    private int getLottoCountForBuying(long price) {
        return Money.from(price).divide(Money.from(Lotto.PRICE)).intValue();
    }
}
