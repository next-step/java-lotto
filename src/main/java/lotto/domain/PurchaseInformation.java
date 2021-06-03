package lotto.domain;

/**
 * 로또 구매 정보
 */
public abstract class PurchaseInformation {
    public static final String MANUAL_LOTTO_COUNT_OVER_MESSAGE = "수동으로 구매할 복권 숫자가 총 구매 횟수보다 많습니다.";
    private final int allLottoCount;
    private final int manualCount;

    protected PurchaseInformation(final int allLottoCount, final int manualCount) {
        validateLottoCount(allLottoCount, manualCount);
        this.allLottoCount = allLottoCount;
        this.manualCount = manualCount;
    }

    private void validateLottoCount(final int allLottoCount, final int manualCount) {
        if (allLottoCount < manualCount) {
            throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_OVER_MESSAGE);
        }
    }

    public abstract int getLottoCount();

    protected int getAllLottoCount() {
        return allLottoCount;
    }

    protected int getManualCount() {
        return manualCount;
    }
}
