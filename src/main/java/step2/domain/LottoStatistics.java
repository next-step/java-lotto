package step2.domain;

import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final RankOfMatch rankOfMatch;

    public LottoStatistics(List<Integer> rankOfMatchList) {
        this.rankOfMatch = new RankOfMatch(rankOfMatchList);
    }

    public Map<Integer, Long> statistics(List<Boolean> matchOfBonus) {
        return rankOfMatch.groupMatchOfLotto(matchOfBonus.iterator());
    }

    public double calculateProfitRate(Money money) {
        return rankOfMatch.calculateProfitRate(money);
    }

}
