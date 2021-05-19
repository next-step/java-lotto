package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public Lottos buyLottos(long price) {
        return IntStream.rangeClosed(1, getLottoCountForBuying(price))
                        .mapToObj(count -> Lotto.auto())
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    private int getLottoCountForBuying(long price) {
        return Money.from(price).divide(Money.from(Lotto.PRICE)).intValue();
    }
}
