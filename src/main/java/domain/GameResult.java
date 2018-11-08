package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class GameResult {

    private static final int THREE_MATCHES_PRICE = 5000;
    private static final int FOUR_MATCHES_PRICE = 50000;
    private static final int FIVE_MATCHES_PRICE = 150000;
    private static final int SIX_MATCHES_PRICE = 2000000000;
    private static final int ZERO_PRICE = 0;

    private static final int MATCH_COUNT_THREE = 3;
    private static final int MATCH_COUNT_FOUR = 4;
    private static final int MATCH_COUNT_FIVE =5;
    private static final int MATCH_COUNT_SIX = 6;

    private static final int ROUNDING_SCALE = 2;

    private Map<Integer, Integer> lottoResults;
    private int purchaseAmount;

    public GameResult(Map<Integer, Integer> lottoResults, int purchaseAmount) {
        this.lottoResults = lottoResults;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Integer, Integer> getLottoResults() {
        return this.lottoResults;
    }

    public BigDecimal calculateBenefitRate() {
        BigDecimal totalAmount = new BigDecimal(calculateTotalAmount());
        BigDecimal amount = new BigDecimal(this.purchaseAmount);

        return totalAmount.divide(amount, ROUNDING_SCALE, RoundingMode.DOWN);
    }

    protected int calculateTotalAmount() {
        int benefitAmount = 0;

        for(Map.Entry<Integer, Integer> entry : lottoResults.entrySet()) {
            int winAmountPerMatching = getWinAmountPerMatch(entry.getKey()) * lottoResults.get(entry.getKey());
            benefitAmount += winAmountPerMatching;
        }
        return benefitAmount;
    }

    private int getWinAmountPerMatch(int i) {
        if(i == MATCH_COUNT_THREE) {
            return THREE_MATCHES_PRICE;
        }

        if(i == MATCH_COUNT_FOUR) {
            return FOUR_MATCHES_PRICE;
        }

        if(i == MATCH_COUNT_FIVE){
            return FIVE_MATCHES_PRICE;
        }

        if(i == MATCH_COUNT_SIX) {
            return SIX_MATCHES_PRICE;
        }
        return ZERO_PRICE;
    }
}
