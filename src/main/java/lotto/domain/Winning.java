package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Winning {
    public static final int FORWARD_WINNER = 2;
    private Map<Integer, Integer> winnerCountMap;

    public Winning() {
        this.winnerCountMap = new HashMap<>();
    }
    public void addWinning(int rightNumber) {
        if (isWinning(rightNumber)) {
            winnerCountMap.put(rightNumber, winnerCountMap.getOrDefault(rightNumber, 0) + 1);
        }
    }

    private boolean isWinning(final int rightNumber) {
        return rightNumber > FORWARD_WINNER;
    }

    public int getWinnerCount(int winnerNumber) {
        return winnerCountMap.getOrDefault(winnerNumber, 0);
    }

    public BigDecimal getReturnRate(final int purchaseAmount) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Integer key : winnerCountMap.keySet()) {
            final BigDecimal countPrice = Rank.priceOf(key);

            final BigDecimal count = new BigDecimal(winnerCountMap.get(key));
            sum = countPrice.multiply(count);
        }

        return sum.divide(new BigDecimal(purchaseAmount));
    }
}
