package lotto.domain;

import java.util.Objects;

public class LottosCount {

    private final long lottosCount;

    public LottosCount(long lottosCount) {
        validateLottoCount(lottosCount);
        this.lottosCount = lottosCount;
    }

    private void validateLottoCount(long lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("구매한 로또의 개수가 음수일 수 없습니다. 현재 개수: " + lottoCount);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottosCount that = (LottosCount) o;
        return lottosCount == that.lottosCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottosCount);
    }

    @Override
    public String toString() {
        return "LottosCount{" +
                "lottosCount=" + lottosCount +
                '}';
    }
}
