package model;

import java.util.List;

public class LottoStore {
    private static int LOTT_PRICE = 1000;
    private int buyAmount;

    public LottoStore() {
    }

    public int getCount() {
        return this.buyAmount / this.LOTT_PRICE;
    }

    public List<Lotto> Buy(int buyAmount) {
        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        lottoGenerator.generatorLotto(buyAmount);
        return lottoGenerator.getLottos();
    }
}
