package lottogame.domain.response;

import java.util.Objects;

public final class LottoCheckResponse {

    private final int matchedCount;
    private final boolean isBonusMatched;

    public LottoCheckResponse(int matchedCount, boolean isBonusMatched) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCheckResponse)) {
            return false;
        }
        LottoCheckResponse that = (LottoCheckResponse) o;
        return matchedCount == that.matchedCount && isBonusMatched == that.isBonusMatched;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount, isBonusMatched);
    }

    @Override
    public String toString() {
        return "LottoCheckResponse{" +
            "matchedCount=" + matchedCount +
            ", isBonusMatched=" + isBonusMatched +
            '}';
    }
}
