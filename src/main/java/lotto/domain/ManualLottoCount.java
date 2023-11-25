package lotto.domain;

import java.util.Objects;
import lotto.util.validator.GeneralValidator;

public class ManualLottoCount {
    private final int manualLottoCount;

    public ManualLottoCount(int manualLottoCount, LottoCount totalLottoCount) {
        validateRange(manualLottoCount, totalLottoCount);
        this.manualLottoCount = manualLottoCount;
    }

    public ManualLottoCount(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
    }

    public static ManualLottoCount from(int manualLottoCount) {
        return new ManualLottoCount(manualLottoCount);
    }

    public static ManualLottoCount of(int manualLottoCount, LottoCount totalLottoCount) {
        return new ManualLottoCount(manualLottoCount, totalLottoCount);
    }

    private void validateRange(int manualLottoCount, LottoCount totalLottoCount) {
        GeneralValidator.validatePositiveNumber(manualLottoCount, "수동 로또의 개수");
        if (!totalLottoCount.isCountGreaterOrEqualTo(manualLottoCount)) {
            throw new IllegalArgumentException("수동 로또의 개수는 전체 로또 개수를 초과할 수 없습니다.");
        }
    }

    public int calculateAutoLottoCountByTotalCount(LottoCount totalLottoCount) {
        return totalLottoCount.minusBy(manualLottoCount);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManualLottoCount that = (ManualLottoCount) o;
        return manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoCount);
    }
}
