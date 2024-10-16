package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class LottoService {
    private final static int lottoPrice = 1000;

    private final Lotto lotto;

    public LottoService() {
        this.lotto = new Lotto();
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public List<Integer>[] purchaseLotto(int lottoCount) {
        return lotto.purchaseLotto(lottoCount);
    }
}
