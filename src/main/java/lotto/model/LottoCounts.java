package lotto.model;

import java.util.Objects;

public class LottoCounts {

    private final LottoCount autoLottoCount;
    private final LottoCount manualLottoCount;

    public LottoCounts(final int totalLottoCount, final int manualLottoCount) {
        validate(totalLottoCount, manualLottoCount);

        this.autoLottoCount = new LottoCount(totalLottoCount - manualLottoCount);
        this.manualLottoCount = new LottoCount(manualLottoCount);
    }

    private void validate(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException(
                    "수동 로또의 개수는 전체 로또의 개수를 넘을 수 없습니다. 현재 입력값: 전체 로또 = " + totalLottoCount
                            + ", 수동 로또 = " + manualLottoCount + " 입니다.");
        }
    }

    public int getAutoLottoCount() {
        return autoLottoCount.getCount();
    }

    public int getManualLottoCount() {
        return manualLottoCount.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCounts that = (LottoCounts) o;
        return Objects.equals(autoLottoCount, that.autoLottoCount)
                && Objects.equals(manualLottoCount, that.manualLottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoLottoCount, manualLottoCount);
    }
}
