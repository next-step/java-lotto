package lotto.domain;

import lotto.enums.MatchType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;

public class GameResult {

    public static final int ROUND_SCALE = 2;
    public static final int MATCH_CASE_NUM = 7;
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    private List<Ticket> tickets;
    private int[] results = new int[MATCH_CASE_NUM];

    public GameResult(List<Ticket> tickets, Ticket winningNumbers) {
        this.tickets = tickets;
        this.results = generateGameResult(winningNumbers);
    }

     private int[] generateGameResult(Ticket winningNumbers) {
        IntStream.range(0, this.tickets.size())
                .forEach(i -> this.results[this.tickets.get(i).getCountOfMatches(winningNumbers)]++);

        return this.results;
    }

    public BigDecimal getBenefitRate() {
        BigDecimal totalWinAmount = new BigDecimal(calculateTotalAmount(this.results));
        BigDecimal purchaseAmount = new BigDecimal(getPurchaseAmount());

        return calculateBenefitRate(totalWinAmount, purchaseAmount);
    }

    public static BigDecimal calculateBenefitRate(BigDecimal totalWinAmount, BigDecimal purchaseAmount) {
        return totalWinAmount.divide(purchaseAmount, ROUND_SCALE, RoundingMode.DOWN);
    }

    public int getPurchaseAmount() {
        return this.tickets.size() * PRICE_PER_ONE_LOTTO;
    }

    protected static int calculateTotalAmount(int results[]) {
        return IntStream.range(0, results.length)
                .map(i -> MatchType.getMatchedPrice(i) * results[i])
                .sum();
    }

    public int[] getResults() {
        return this.results;
    }
}
