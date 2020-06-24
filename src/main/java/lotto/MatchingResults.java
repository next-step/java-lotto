package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingResults {
    private static final int SCALE_NUMBER_2 = 2;
    private final List<MatchingResult> results = new ArrayList<>();
    private final int countOfLotto;

    MatchingResults(int countOfLotto) {
        this.countOfLotto = countOfLotto;

        results.add(new MatchingResult(Rank.FIRST_PLACE));
        results.add(new MatchingResult(Rank.SECOND_PLACE));
        results.add(new MatchingResult(Rank.THIRD_PLACE));
        results.add(new MatchingResult(Rank.FOURTH_PLACE));
    }

    public List<MatchingResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    public double getProfit() {
        BigDecimal priceMoney = totalPrizeMoney();
        BigDecimal money = Money.buyingMoney(countOfLotto);
        return priceMoney.divide(money, SCALE_NUMBER_2, BigDecimal.ROUND_CEILING).doubleValue();
    }

    private BigDecimal totalPrizeMoney() {
        BigDecimal decimal = BigDecimal.ZERO;
        for (MatchingResult result : results) {
            decimal = decimal.add(result.prizePerRank());
        }
        return decimal;
    }

    void add(Rank rank) {
        if (rank == null || rank == Rank.FAILURE) {
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
}