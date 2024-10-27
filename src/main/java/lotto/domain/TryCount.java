package lotto.domain;

import java.util.Objects;

public class TryCount {
    public static final int CONVERTING_FLOOR_NUMBER = 1000;
    int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount initTryCount(int purchaseAmount) {
        checkAmount(purchaseAmount);
        return new TryCount(amountToTryCount(purchaseAmount));
    }

    private static void checkAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private static int amountToTryCount(int purchaseAmount) {
        return Math.floorDiv(purchaseAmount, CONVERTING_FLOOR_NUMBER);
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryCount);
    }
}
