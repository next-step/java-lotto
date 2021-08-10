package lotto.domain;

import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class LottoMachine {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;

    public Lottos buyLotto(final int amount, final PurchaseStrategy purchaseStrategy) {
        validateAmount(amount);
        return new Lottos(createLotto(amount, purchaseStrategy));
    }

    private void validateAmount(final int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private List<Lotto> createLotto(final int amount, final PurchaseStrategy purchaseStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = amount / LOTTO_PRICE;
        for (int i = INIT_COUNT; i < lottoCount; i++) {
            lottos.add(new Lotto(purchaseStrategy.generateLottoNumber()));
        }
        return lottos;
    }

}
