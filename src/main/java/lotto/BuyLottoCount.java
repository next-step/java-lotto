package lotto;

import java.util.Objects;

public class BuyLottoCount {
    private final int manualLottoCount;
    private final int autoLottoCount;

    public BuyLottoCount(int manualLottoCount, int autoLottoCount) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public BuyLottoCount(int manualLottoCount, Pay pay) {
        if (!pay.isCanBuyManualLottoCount(manualLottoCount)) {
            throw new IllegalArgumentException("수동 로또를 살 수 있는 갯수를 초과하였습니다.");
        }
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = pay.countAutoLotto(manualLottoCount);
    }

    public int getManualCount() {
        return this.manualLottoCount;
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyLottoCount that = (BuyLottoCount) o;
        return manualLottoCount == that.manualLottoCount && autoLottoCount == that.autoLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoCount, autoLottoCount);
    }
}
