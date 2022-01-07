package lotto.domain;

public class LottoCount {

    private final int totalCount;

    private final int manualCount;

    public LottoCount(final int totalCount, final int manualCount) {
        checkCount(totalCount, manualCount);
        this.totalCount = totalCount;
        this.manualCount = manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return totalCount - manualCount;
    }

    private void checkCount(int totalCount, int manualCount) {
        if (totalCount < manualCount) {
            throw new IllegalStateException("수동으로 구매할 로또의 갯수가 전체 로또의 갯수보다 많습니다.");
        }
    }
}
