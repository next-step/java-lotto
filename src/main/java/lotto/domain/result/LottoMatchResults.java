package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.LottoReward;

public class LottoMatchResults{
    private List<MatchResult> matchResults = new ArrayList<>();

    LottoMatchResults() {
        matchResults.add(new MatchResult(0, LottoReward.MISS));
        matchResults.add(new MatchResult(0, LottoReward.FIFTH));
        matchResults.add(new MatchResult(0, LottoReward.FOURTH));
        matchResults.add(new MatchResult(0, LottoReward.THIRD));
        matchResults.add(new MatchResult(0, LottoReward.SECOND));
        matchResults.add(new MatchResult(0, LottoReward.FIRST));
    }

    void addMatchNumber(LottoReward lottoReward) {
        MatchResult matchResult = matchResults.stream().filter(it -> it.getLottoReward() == lottoReward).findFirst().orElseThrow(); // TODO error 처리?
        matchResult.addMatchCount();
    }

    long getLottoReward() {
        long totalReward = 0;
        for (MatchResult matchResult : matchResults) {
            totalReward += matchResult.getMatchReward();
        }

        return totalReward;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoMatchResults lottoMatchResults = (LottoMatchResults) obj;
        return this.matchResults.equals(lottoMatchResults.matchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResults);
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }
}
