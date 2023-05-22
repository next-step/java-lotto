package lotto.domain;

public class MyLotto {

    private static final int LOTTO_PRICE = 1000;

    private final LottoCount lottoCount;

    MyLotto(int purchasePrice) {
        this.lottoCount = new LottoCount(purchasePrice, LOTTO_PRICE);
    }

    public boolean lottoCountIsEqualTo(int otherLottoCount) {
        return this.lottoCount.isEqualTo(otherLottoCount);
    }
}
