package lotto.domain;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    private static final int START_COUNT = 0;
    private static final int PRICE_PER_LOTTO = 1000;
    private static final NumberGenerator numberGenerator = new LottoNumberGenerator();

    public Lottos purchase(PurchaseMoney purchaseMoney) {
        int lottoCount = getPossiblePurchaseLottoCount(purchaseMoney);

        return IntStream.range(START_COUNT, lottoCount)
                .mapToObj(i -> Lotto.createFrom(numberGenerator))
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    private int getPossiblePurchaseLottoCount(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getValue() / PRICE_PER_LOTTO;
    }
}
