package lotto;

import java.util.Objects;

public class LottoResult {
    private final int matchedLottoNumbers;

    private LottoResult(int matchedLottoNumbers) {
        this.matchedLottoNumbers = matchedLottoNumbers;
    }

    public static LottoResult of(int matchedLottoNumbers) {
        return new LottoResult(matchedLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return matchedLottoNumbers == that.matchedLottoNumbers;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchedLottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "matchedLottoNumbers=" + matchedLottoNumbers +
                '}';
    }
}
