package lotto.domain;

import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(int amount, PurchaseStrategy purchaseStrategy) {
        validateAmount(amount);
        // purchaseStrategy.generateLottoNumber();
    }

    private void validateAmount(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    public List<Lotto> drawing() {
        return lottos;
    }

}
