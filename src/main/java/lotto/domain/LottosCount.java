package lotto.domain;

import java.util.Objects;
import java.util.stream.LongStream;

public class LottosCount {

    private final long lottosCount;

    public LottosCount(long lottosCount) {
        validateLottoCount(lottosCount);
        this.lottosCount = lottosCount;
    }

    private void validateLottoCount(long lottosCount) {
        if (lottosCount < 0) {
            throw new IllegalArgumentException("구매한 로또의 개수가 음수일 수 없습니다. 현재 개수: " + lottosCount);
        }
    }

    public long getLottosCount() {
        return lottosCount;
    }

    public LottosCount subtract(LottosCount anotherLottosCount) {
        return new LottosCount(this.lottosCount - anotherLottosCount.lottosCount);
    }

    public LongStream makeLottosCountToLongStream() {
        return LongStream.range(0, this.lottosCount);
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
