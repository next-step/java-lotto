package lotto.domain;

import lotto.util.RandomLottoGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    public long getLottosCount() {
        return lottosCount;
    }

    public LottosCount findAnotherCount(Money money) {
        return new LottosCount(money.countLotto() - this.lottosCount);
    }

    public boolean isSameLottosCount(long lottosCount) {
        return this.lottosCount == lottosCount;
    }

    public List<Lotto> generateRandomLottos() {
        return LongStream.range(0, this.lottosCount)
                .mapToObj(l -> RandomLottoGenerator.generateLotto())
                .collect(Collectors.toList());
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
