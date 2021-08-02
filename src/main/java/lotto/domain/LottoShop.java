package lotto.domain;

import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> buyLotto(int amount, PurchaseStrategy purchaseStrategy) {
        validateAmount(amount);
        printLotto(amount, purchaseStrategy);
        return lottos;
    }

    private void validateAmount(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private void printLotto(int amount, PurchaseStrategy purchaseStrategy) {
        for(int i = 0; i < amount/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(purchaseStrategy.generateLottoNumber()));
        }
    }

}
