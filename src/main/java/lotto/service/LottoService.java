package lotto.service;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final static int lottoPrice = 1000;

    private final LottoSeller lottoSeller;

    public LottoService() {
        lottoSeller = new LottoSeller();
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public void purchaseLottos(int lottoCount) {
        lottoSeller.sellLottos(lottoCount);
    }

    public Map<Integer, List<Integer>> getLottos() {
        return lottoSeller.provideLottos();
    }

}
