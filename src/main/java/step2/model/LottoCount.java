package step2.model;

import java.util.Objects;

public class LottoCount {

    private static final int MIN_VALUE = 1;

    private final int count;

    private LottoCount(int count) {
        if (count < MIN_VALUE) {
            throw new IllegalArgumentException("최소 1개 이상 가능합니다.");
        }

        this.count = count;
    }

    public static LottoCount valueOf(int count) {
        return new LottoCount(count);
    }

    public boolean isOverManualCount(ManualLottoNumbers manualLottoNumbers) {
        return count < manualLottoNumbers.getManualCount();
    }

    public int calculateAutoCount(ManualLottoNumbers manualLottoNumbers) {
        if (isOverManualCount(manualLottoNumbers)) {
            throw new IllegalArgumentException("수동 개수는 총 개수보다 작아야 합니다.");
        }

        return count - manualLottoNumbers.getManualCount();
    }

    public int getValue() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
