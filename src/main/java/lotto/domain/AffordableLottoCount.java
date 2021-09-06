package lotto.domain;

public class AffordableLottoCount {
    private static final String EXCEP_INVALID_AFFORDABLE_LOTTO_COUNT = "AffordableLottoCount 데이터로 유효하지 않습니다.";
    private final int totalAffordableCount;
    private final int manualLottoCount;

    AffordableLottoCount(int totalAffordableCount, int manualLottoCount) {
        validate(totalAffordableCount, manualLottoCount);
        this.totalAffordableCount = totalAffordableCount;
        this.manualLottoCount = manualLottoCount;
    }

    void validate(int totalAffordableCount, int manualLottoCount) {
        if (totalAffordableCount < manualLottoCount) {
            throw new IllegalArgumentException(EXCEP_INVALID_AFFORDABLE_LOTTO_COUNT);
        }
    }

    public int getCountToAutoGenerate() {
        return totalAffordableCount - manualLottoCount;
    }
}
