package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class BuyAutoLotto extends BuyLotto {
    public BuyAutoLotto(Money money, int count, List<LottoNumberStrategy> strategies) {
        super(money, count, strategies);
    }

    public static BuyAutoLotto create(Money money, int count) {
        List<LottoNumberStrategy> strategies = IntStream.range(0, count)
                .mapToObj(it -> RandomLottoNumberStrategy.CACHED)
                .collect(Collectors.toList());
        return new BuyAutoLotto(money, count, strategies);
    }
}
