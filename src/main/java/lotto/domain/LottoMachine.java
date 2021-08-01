package lotto.domain;

import java.util.List;

public class LottoMachine {
    int purchaseLottoCount;
    private LottoNumber lottoNumber;

    static int PRICE_OF_LOTTO = 1000;

    public LottoMachine(int purchaseAmount) {
        purchaseLottoCount = purchaseAmount / PRICE_OF_LOTTO;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public LottoNumber generateLottoNumber(List<Integer> asList) {
        lottoNumber = new LottoNumber(asList);

        return lottoNumber;
    }

    public LottoNumber generateLottoNumber() {
        return new LottoNumber();
    }
}
