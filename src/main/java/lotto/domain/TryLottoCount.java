package lotto.domain;

import java.util.Objects;

public class TryLottoCount {
    int tryLottoCount;

    public TryLottoCount(int tryLottoCount) {
        this.tryLottoCount = tryLottoCount;
    }

    public int currentCount() {
        return tryLottoCount;
    }

    public int calculateLottoTryCount(int purchaseAmount) {
        tryLottoCount = Math.floorDiv(purchaseAmount, 1000);
        return tryLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryLottoCount that = (TryLottoCount) o;
        return tryLottoCount == that.tryLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryLottoCount);
    }
}
