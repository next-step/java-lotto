package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto.LOTTO_REWARD;

public class LottoMatchResults{
    private List<MatchResult> matchResults = new ArrayList<>();


    LottoMatchResults() {
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(1)));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(2)));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(3)));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(4)));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(5)));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.valueOf(6)));
    }

    void addMatchNumber(int matchNumber) {
        if (matchNumber < 1 || matchNumber > 6) {
            return;
        }

        matchResults.get(matchNumber - 1).addMatchCount();
    }

    int getLottoReward() {
        int totalReward = 0;
        for (MatchResult matchResult : matchResults) {
            totalReward += matchResult.getTotalReward();
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
