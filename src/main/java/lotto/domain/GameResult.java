package lotto.domain;

import lotto.enums.MatchType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class GameResult {

    public static final int ROUND_SCALE = 2;
    public static final int MATCH_CASE_NUM = 7;
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    private List<Ticket> tickets;

    public GameResult(List<Ticket> tickets, Ticket winningNumbers) {
        this.tickets = tickets;
        generateGameResult(winningNumbers);
    }

     protected void generateGameResult(Ticket winningNumbers) {
         this.tickets.stream()
                 .mapToInt(ticket -> ticket.getCountOfMatches(winningNumbers))
                 .forEach(MatchType::updateCount);
    }

    public BigDecimal getBenefitRate() {
        BigDecimal totalWinAmount = new BigDecimal(MatchType.getTotalAmount());
        BigDecimal purchaseAmount = new BigDecimal(getPurchaseAmount());

        return calculateBenefitRate(totalWinAmount, purchaseAmount);
    }

    public static BigDecimal calculateBenefitRate(BigDecimal totalWinAmount, BigDecimal purchaseAmount) {
        return totalWinAmount.divide(purchaseAmount, ROUND_SCALE, RoundingMode.DOWN);
    }

    public int getPurchaseAmount() {
        return this.tickets.size() * PRICE_PER_ONE_LOTTO;
    }
}
