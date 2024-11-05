package lotto.domain;

import java.util.Objects;

public class TryCount {
    public static final int CONVERTING_FLOOR_NUMBER = 1000;
    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount initTryCount(int purchaseAmount) {
        return initTryCount(purchaseAmount, 0);
    }

    public static TryCount initTryCount(int purchaseAmount, int manualTry) {
        checkAmount(purchaseAmount);
        int tryCount = updateWithManualTry(amountToTryCount(purchaseAmount), manualTry);
        return new TryCount(tryCount);
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

    public static int updateWithManualTry(int tryCount, int manualTry) {
        validateManualTry(tryCount, manualTry);
        return tryCount - manualTry;
    }

    public static void validateManualTry(int tryCount, int manualTry) {
        if (manualTry < 0 || tryCount < manualTry) {
            throw new IllegalArgumentException("수동로또 번호가 0미만이거나 로또 구매 횟수를 초과합니다.");
        }
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
