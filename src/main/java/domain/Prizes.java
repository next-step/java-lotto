package domain;

import java.util.HashMap;
import java.util.Map;

public class Prizes {
    private static final int INITIAL_PRIZE_COUNT = 0;

    private final Map<PrizeCondition, Prize> prizes = new HashMap<PrizeCondition, Prize>() {{
        put(PrizeCondition.FIRST, new Prize(PrizeCondition.FIRST, INITIAL_PRIZE_COUNT));
        put(PrizeCondition.SECOND, new Prize(PrizeCondition.SECOND, INITIAL_PRIZE_COUNT));
        put(PrizeCondition.THIRD, new Prize(PrizeCondition.THIRD, INITIAL_PRIZE_COUNT));
        put(PrizeCondition.FOURTH, new Prize(PrizeCondition.FOURTH, INITIAL_PRIZE_COUNT));
        put(PrizeCondition.FIFTH, new Prize(PrizeCondition.FIFTH, INITIAL_PRIZE_COUNT));
    }};

    public int match(PrizeCondition prizeCondition) {
        return prizes.get(prizeCondition).getCount();
    }

    public double profitRate(int investment) {
        return (double) sumProfit() / investment;
    }

    public void savePrize(PrizeCondition prizeCondition) {
        Prize prize = prizes.get(prizeCondition).incrementedPrize();
        prizes.put(prizeCondition, prize);
    }

    private int sumProfit() {
        int totalProfit = 0;

        for (Prize prize : prizes.values()) {
            totalProfit += prize.profit();
        }

        return totalProfit;
    }
}
