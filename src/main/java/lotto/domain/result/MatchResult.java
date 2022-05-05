package lotto.domain.result;

import java.util.Objects;

class MatchResult {
    private int matchCount;
    private int reward;

    MatchResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    int getTotalReward() {
        return matchCount * reward;
    }

    void addMatchCount() {
        ++matchCount;
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
        return this.matchCount == matchResult.matchCount && this.reward == matchResult.reward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, reward);
    }

    @Override
    public String toString() {
        return "(" + reward + ")- " + matchCount + "개";
    }
}
