package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoMachine {
    int purchaseLottoCount;
    LottoNumber lottoNumber;

    static int AMOUNT_PER_LOTTO = 1000;

    public LottoMachine(int purchaseAmount){
        purchaseLottoCount = purchaseAmount / AMOUNT_PER_LOTTO;
    }

    public int getPurchaseLottoCount(){
        return purchaseLottoCount;
    }

    public LottoNumber generateLottoNumber(List<Integer> asList) {
        lottoNumber = new LottoNumber(asList);

        return lottoNumber;
    }

    public LottoNumber generateLottoNumber(){
        return new LottoNumber();
    }
}
