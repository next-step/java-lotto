package lotto.result;

import java.util.Objects;

public class LottoResult implements Comparable<LottoResult> {
    private final int matchedLottoNumbersCount;

    public LottoResult(int matchedLottoNumbersCount) {
        this.matchedLottoNumbersCount = matchedLottoNumbersCount;
    }

    public int getMatchedLottoNumbersCount() {
        return matchedLottoNumbersCount;
    }

    @Override
    public int compareTo(LottoResult other) {
        return Integer.compare(this.matchedLottoNumbersCount, other.matchedLottoNumbersCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return matchedLottoNumbersCount == that.matchedLottoNumbersCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchedLottoNumbersCount);
    }

}
