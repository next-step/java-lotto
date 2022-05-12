package lotto.domain.result;

import java.util.Objects;

public class MatchResult {
    private int matchedLottoNumberCount;
    private long reward;

    MatchResult(int matchedLottoNumberCount, long reward) {
        this.matchedLottoNumberCount = matchedLottoNumberCount;
        this.reward = reward;
    }

    long getTotalReward() {
        return matchedLottoNumberCount * reward;
    }

    void addMatchCount() {
        ++matchedLottoNumberCount;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public long getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchResult matchResult = (MatchResult) obj;
        return this.matchedLottoNumberCount == matchResult.matchedLottoNumberCount && this.reward == matchResult.reward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedLottoNumberCount, reward);
    }
}
