package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(int lottoCount) {
        return new LottoCount(lottoCount);
    }

    public static LottoCount fromPurchaseAmount(PurchaseAmount purchaseAmount) {
        return new LottoCount(purchaseAmount.calculateLottoCount());
    }

    public boolean isCountGreaterThan(int presentLottoCount) {
        return presentLottoCount < lottoCount ;
    }

    public boolean isCountGreaterOrEqualTo(int otherLottoCount) {
        return otherLottoCount <= lottoCount;
    }

    public int calculateDifference(int otherLottoCount) {
        return lottoCount - otherLottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
