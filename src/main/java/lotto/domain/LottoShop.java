package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public List<Lotto> buyLottos(long price) {
        return IntStream.rangeClosed(1, getLottoCountForBuying(price))
                        .mapToObj(count -> Lotto.auto())
                        .collect(Collectors.toList());
    }

    private int getLottoCountForBuying(long price) {
        return Money.from(price).divide(Lotto.PRICE);
    }

}
