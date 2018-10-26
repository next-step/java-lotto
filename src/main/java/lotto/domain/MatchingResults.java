package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingResults {
    private final List<MatchingResult> results = new ArrayList<>();
    private final int countOfLotto;

    MatchingResults(int countOfLotto) {
        this.countOfLotto = countOfLotto;
        
        results.add(new MatchingResult(Rank.FIRST));
        results.add(new MatchingResult(Rank.SECOND));
        results.add(new MatchingResult(Rank.THIRD));
        results.add(new MatchingResult(Rank.FOURTH));
        results.add(new MatchingResult(Rank.FIFTH));
    }

    void add(Rank rank) {
        if (rank == null || rank == Rank.MISS) {
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
