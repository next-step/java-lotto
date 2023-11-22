package lotto.domain;

public class LottoCount {
    private final int lottoCount;

    public LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(PurchaseAmount purchaseAmount) {
        return new LottoCount(purchaseAmount.getLottoCount());
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public boolean isLessThanCount(int presentLottoCount) {
        return presentLottoCount < lottoCount ;
    }
}
