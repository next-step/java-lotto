package lotto.domain;

import java.util.Objects;

public class LottoCount {

    private final int manualCount;
    private final int autoCount;

    public LottoCount(int manualCount, int autoCount) {
        if (manualCount + autoCount < 0) {
            throw new IllegalArgumentException("로또 구매 횟수는 0보다 작을 수 없습니다.");
        }
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
