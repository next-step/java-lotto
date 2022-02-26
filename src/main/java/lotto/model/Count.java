package lotto.model;

public class Count {

    private static final String PRICE_CANNOT_BE_NEGATIVE = "로또의 개수는 음수가 될 수 없습니다.";
    private static final String MAX_MANUAL_LOTTO_COUNT_MESSAGE = "수동 로또는 총 로또 개수보다 클 수 없습니다.";
    private final int autoLottoCount;
    private final int manualLottoCount;

    public Count(int totalLottoCount, int manualLottoCount) {
        checkNegativeCount(manualLottoCount);
        checkMaxManualLottoCount(manualLottoCount, totalLottoCount);
        this.autoLottoCount = totalLottoCount - manualLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    private void checkNegativeCount(int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException(PRICE_CANNOT_BE_NEGATIVE);
        }
    }

    private void checkMaxManualLottoCount(int manualLottoCount, int totalLottoCount) {
        if (manualLottoCount > totalLottoCount) {
            throw new IllegalArgumentException(MAX_MANUAL_LOTTO_COUNT_MESSAGE);
        }
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
