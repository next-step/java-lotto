package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final NumberGenerator numberGenerator = new LottoNumberGenerator();

    public Lottos purchase(PurchaseMoney purchaseMoney, List<LottoNumbers> manualLottoNumbers) {
        int lottoCount = getPossiblePurchaseLottoCount(purchaseMoney);

        return IntStream.range(0, lottoCount)
            .mapToObj(i -> Lotto.createFrom(numberGenerator))
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    private int getPossiblePurchaseLottoCount(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getValue() / PRICE_PER_LOTTO;
    }
}
