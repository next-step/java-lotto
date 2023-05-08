package lottoauto.model;

import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final List<Integer> matchCount;

    public LottoResult(List<Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public double getRate(int amount) {
        double summary = 0;
        for (Integer integer : matchCount) {
            int count = Collections.frequency(matchCount, integer);
            int reward = WinningReward.findRewardByMatches(integer).getReward();

            summary += reward * count;
        }

        return Math.round(summary / amount);

    }

    public List<Integer> getMatchCount() {
        return matchCount;
    }
}
