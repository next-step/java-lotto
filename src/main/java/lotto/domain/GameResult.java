package lotto.domain;

import lotto.enums.MatchType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    public static final int ROUND_SCALE = 2;
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    private List<Ticket> tickets;
    private Map<MatchType, Integer> lottoResults;

    public GameResult(List<Ticket> tickets, WinningLotto winningLotto) {
        this.tickets = tickets;
        this.lottoResults = new HashMap<>();
        generateGameResult(winningLotto);
    }

    protected void generateGameResult(WinningLotto winningLotto) {
        initializeMap();
        this.tickets.stream()
                .map(ticket -> ticket.compareWinningLotto(winningLotto))
                .forEach(this::updateResult);
    }

    private void initializeMap() {
        for (MatchType matchType : MatchType.values()) {
            lottoResults.put(matchType, 0);
        }
    }

    private void updateResult(MatchType type) {
        lottoResults.put(type, lottoResults.get(type) + 1);
    }


    public BigDecimal getBenefitRate() {
        BigDecimal totalWinAmount = new BigDecimal(getTotalAmount());
        BigDecimal purchaseAmount = new BigDecimal(getPurchaseAmount());

        return calculateBenefitRate(totalWinAmount, purchaseAmount);
    }

    protected int getTotalAmount() {
        return Arrays.stream(MatchType.values())
                .mapToInt(i -> i.getPrice() * lottoResults.get(i))
                .sum();
    }

    protected static BigDecimal calculateBenefitRate(BigDecimal totalWinAmount, BigDecimal purchaseAmount) {
        return totalWinAmount.divide(purchaseAmount, ROUND_SCALE, RoundingMode.DOWN);
    }

    public Map<MatchType, Integer> getLottoResults() {
        return lottoResults;
    }

    private int getPurchaseAmount() {
        return this.tickets.size() * PRICE_PER_ONE_LOTTO;
    }
}
