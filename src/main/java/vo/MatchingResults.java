package vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MatchingResults {
    private final List<MatchingResult> results = new ArrayList<>();
    private final int countOfLotto;

    MatchingResults(int countOfLotto) {
        this.countOfLotto = countOfLotto;

        results.add(new MatchingResult(Rank.FIFTH_PLACE));
        results.add(new MatchingResult(Rank.FOURTH_PLACE));
        results.add(new MatchingResult(Rank.THIRD_PLACE));
        results.add(new MatchingResult(Rank.SECOND_PLACE));
        results.add(new MatchingResult(Rank.FIRST_PLACE));
    }

    public void add(Rank rank) {
        if (Objects.isNull(rank) || rank.equals(Rank.FAILURE)) {
            return;
        }
        getMatchingResult(rank).match();
    }

    private MatchingResult getMatchingResult(Rank rank) {
        return results.stream()
                .filter(r -> r.supports(rank))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public double getProfit() {
        Money winningMoney = new Money(0);
        for (MatchingResult result : results) {
            winningMoney = winningMoney.sum(result.prizePerRank());
        }

        return Money.buyingMoney(countOfLotto).profitRate(winningMoney);
    }

    public List<MatchingResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}
