package lotto.domain.result;

import java.util.Objects;

class MatchResult {
    private int matchedLottoNumberCount;
    private int reward;

    MatchResult(int matchedLottoNumberCount, int reward) {
        this.matchedLottoNumberCount = matchedLottoNumberCount;
        this.reward = reward;
    }

    int getTotalReward() {
        return matchedLottoNumberCount * reward;
    }

    void addMatchCount() {
        ++matchedLottoNumberCount;
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

    @Override
    public String toString() {
        return "(" + reward + ")- " + matchedLottoNumberCount + "개";
    }
}
