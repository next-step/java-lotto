package lotto.domain;

public class LottoCount {
    private final int lottoCount;

    LottoCount(int purchasePrice, int lottoPrice) {
        this.lottoCount = purchasePrice / lottoPrice;
    }

    public boolean isEqualTo(int otherLottoCount) {
        return this.lottoCount == otherLottoCount;
    }
}
