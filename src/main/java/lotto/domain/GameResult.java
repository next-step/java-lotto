package lotto.domain;

import lotto.enums.MatchType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class GameResult {

    public static final int ROUND_SCALE = 2;
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    private List<Ticket> tickets;
    private Map<Integer, Integer> lottoResults;

    public GameResult(List<Ticket> tickets, WinningLotto winningLotto) {
        this.tickets = tickets;
        this.lottoResults = new HashMap<>();
        generateGameResult(winningLotto);
    }

    protected void generateGameResult(WinningLotto winningLotto) {
        initializeMap(winningLotto);
        this.tickets.stream()
                .mapToInt(ticket -> ticket.compareWinningLotto(winningLotto))
                .forEach(this::updateResult);
    }

    private void initializeMap(WinningLotto winningNumbers) {
        IntStream.rangeClosed(0, MatchType.BONUS.getMatch())
                .forEach(i -> lottoResults.put(i, 0));
    }

    private void updateResult(int key) {
        lottoResults.put(key, lottoResults.get(key) + 1);
    }


    public BigDecimal getBenefitRate() {
        BigDecimal totalWinAmount = new BigDecimal(getTotalAmount());
        BigDecimal purchaseAmount = new BigDecimal(getPurchaseAmount());

        return calculateBenefitRate(totalWinAmount, purchaseAmount);
    }

    public int getTotalAmount() {
        int totalAmount = 0;

        for(Integer key : lottoResults.keySet()) {
            MatchType matchType = MatchType.getMatchType(key);
            totalAmount += matchType.getPrice() * lottoResults.get(key);
        }

        return totalAmount;
    }

    public static BigDecimal calculateBenefitRate(BigDecimal totalWinAmount, BigDecimal purchaseAmount) {
        return totalWinAmount.divide(purchaseAmount, ROUND_SCALE, RoundingMode.DOWN);
    }

    public Map<Integer, Integer> getLottoResults() {
        return lottoResults;
    }

    public int getPurchaseAmount() {
        return this.tickets.size() * PRICE_PER_ONE_LOTTO;
    }
}
