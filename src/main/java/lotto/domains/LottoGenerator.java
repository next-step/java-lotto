package lotto.domains;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public List<Lotto> purchaseByAuto(LottoPurchasedAmount amount) {
        return IntStream.range(0, amount.getAmount() / Lotto.PRICE)
                .boxed()
                .map(i -> Lotto.createByAuto())
                .collect(Collectors.toList());
    }
}
