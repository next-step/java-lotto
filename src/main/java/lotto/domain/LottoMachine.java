package lotto.domain;

import java.util.Collections;

public class LottoMachine {
    int purchaseLottoCount;

    static int AMOUNT_PER_LOTTO = 1000;

    public LottoMachine(int purchaseAmount){
        purchaseLottoCount = purchaseAmount / AMOUNT_PER_LOTTO;
    }

    public int getPurchaseLottoCount(){
        return purchaseLottoCount;
    }
}
