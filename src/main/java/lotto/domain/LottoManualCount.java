package lotto.domain;

public class LottoManualCount {
    private static final int NO_COUNT = 0;
    private final int lottoManualCount;

    public LottoManualCount(int lottoManualCount) {
        if (lottoManualCount < NO_COUNT) {
            throw new IllegalArgumentException("수동 로또 구매 개수는 0개 이상만 가능합니다.");
        }
        this.lottoManualCount = lottoManualCount;
    }

    public int manualCount() {
        return this.lottoManualCount;
    }

    public boolean hasBuyCount() {
        return this.lottoManualCount > NO_COUNT;
    }
}
