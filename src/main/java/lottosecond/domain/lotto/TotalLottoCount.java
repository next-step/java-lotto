package lottosecond.domain.lotto;

import lottosecond.domain.Money;

public class TotalLottoCount {

    private final LottoCount manualLottoCount;
    private final LottoCount autoLottoCount;

    public TotalLottoCount(Money money, int manualLottoCount) {
        int totalLottoCount = money.countLotto();
        this.manualLottoCount = LottoCount.from(manualLottoCount, totalLottoCount);
        this.autoLottoCount = LottoCount.from(totalLottoCount - manualLottoCount, totalLottoCount);
    }

    public int totalLottoCount() {
        return manualLottoCount.getLottoCount() + autoLottoCount.getLottoCount();
    }

    public int manualLottoCount() {
        return manualLottoCount.getLottoCount();
    }

    public int autoLottoCount() {
        return autoLottoCount.getLottoCount();
    }
}
