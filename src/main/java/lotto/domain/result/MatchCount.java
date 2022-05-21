package lotto.domain.result;

import java.util.Objects;

public class MatchCount {
    int matchCount;

    MatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    void addMatchCount() {
        ++matchCount;
    }

    int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchCount matchCount = (MatchCount) obj;
        return this.matchCount == matchCount.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
