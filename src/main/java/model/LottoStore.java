package model;

import java.util.List;

public class LottoStore {
    private static int LOTT_PRICE = 1000;

    public LottoStore() {
    }

    public List<Lotto> Buy(int buyAmount) {
        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        lottoGenerator.generatorLotto(buyAmount/LOTT_PRICE);
        return lottoGenerator.getLottos();
    }
}
