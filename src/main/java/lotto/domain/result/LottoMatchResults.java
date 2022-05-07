package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto.LOTTO_REWARD;

class LottoMatchResults{
    private List<MatchResult> matchResults = new ArrayList<>();


    LottoMatchResults() {
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_1.getReward()));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_2.getReward()));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_3.getReward()));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_4.getReward()));
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_5.getReward()));;
        matchResults.add(new MatchResult(0, LOTTO_REWARD.MATCH_6.getReward()));
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 2; i < 6; ++i) {
            result.append(i + 1).append("개 일치 ");
            result.append(matchResults.get(i)).append("\n");
        }

        return result.substring(0, result.length() - 1);
    }
 }
