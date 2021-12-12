package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int FOURTH_WIN_MATCH_COUNT = 3;
    private static final int THIRD_WIN_MATCH_COUNT = 4;
    private static final int SECOND_WIN_MATCH_COUNT = 5;
    private static final int FIRST_WIN_MATCH_COUNT = 6;

    private static final int YES_MATCH_COUNT = 1;
    private static final int NONE_MATCH_COUNT = 0;

    private static final long WIN_MONEY_FOR_FOURTH_WINNER = 5000;
    private static final long WIN_MONEY_FOR_THIRD_WINNER = 50000;
    private static final long WIN_MONEY_FOR_SECOND_WINNER = 1500000;
    private static final long WIN_MONEY_FOR_FIRST_WINNER = 2000000000;


    private final Map<Integer, Integer> matchCount;
    private double profit;

    public LottoResult() {
        this.matchCount = new HashMap<>();
        this.profit = 0;
    }

    public LottoResult(Map<Integer, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public void updateMatchCount(Lotto lotto, Lotto winnerLotto) {
        int count = lotto.countMatch(winnerLotto);
        if (count >= FOURTH_WIN_MATCH_COUNT) {
            updateMatchCount(count);
        }
    }

    private void updateMatchCount(int matchCount) {
        this.matchCount.merge(matchCount, YES_MATCH_COUNT, Integer::sum);
    }

    public int askWinnerCount(int matchCount) {
        return this.matchCount.getOrDefault(matchCount, NONE_MATCH_COUNT);
    }

    public double getProfit() {
        return profit;
    }

    public void updateProfit(int lottoSize, Money lottoPrice) {
        this.profit = calculateProfit(lottoSize, lottoPrice);
    }

    private double calculateProfit(int lottoSize, Money lottoPrice) {
        Money originalMoney = lottoPrice.multiply(lottoSize);
        Money winMoney = new Money();

        winMoney.add(WIN_MONEY_FOR_FOURTH_WINNER * askWinnerCount(FOURTH_WIN_MATCH_COUNT));
        winMoney.add(WIN_MONEY_FOR_THIRD_WINNER * askWinnerCount(THIRD_WIN_MATCH_COUNT));
        winMoney.add(WIN_MONEY_FOR_SECOND_WINNER * askWinnerCount(SECOND_WIN_MATCH_COUNT));
        winMoney.add(WIN_MONEY_FOR_FIRST_WINNER * askWinnerCount(FIRST_WIN_MATCH_COUNT));

        return winMoney.calculateProfit(originalMoney);
    }
}
