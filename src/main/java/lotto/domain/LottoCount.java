package lotto.domain;

import java.util.OptionalInt;

public class LottoCount {
    private final int manualLottoCount;
    private final int autoLottoCount;

    public LottoCount(int manualLottoCount, LottoPrice lottoCount) {
        if (!lottoCount.validManualCount(manualLottoCount)) {
            throw new IllegalArgumentException("구매 가능한 복권 개수가 아닙니다.");
        }
        this.manualLottoCount = OptionalInt.of(manualLottoCount).orElse(0);
        this.autoLottoCount = lottoCount.buyManualLottoCount(manualLottoCount);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
