package lotto.domain;

public class LottoCount {
    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(PurchaseAmount purchaseAmount) {
        return new LottoCount(purchaseAmount.getLottoCount());
    }

    public boolean isLessThanCount(int presentLottoCount) {
        return presentLottoCount < lottoCount ;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
