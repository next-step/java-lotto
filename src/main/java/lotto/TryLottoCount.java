package lotto;

import java.util.Objects;

public class TryLottoCount {
    int tryLottoCount;

    public TryLottoCount(int tryLottoCount) {
        this.tryLottoCount = tryLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryLottoCount that = (TryLottoCount) o;
        return tryLottoCount == that.tryLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryLottoCount);
    }
}
