package step2.domain;

import java.util.List;

public class LottoStore {
    private final int PRICE = 1000;

    public int getPurchaseLottoCount(int purchasePrice) {
        return purchasePrice / this.PRICE;
    }

    public List<Integer> getLottoNumbers() {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.getLottoNumbers();
    }
}
