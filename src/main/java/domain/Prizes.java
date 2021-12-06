package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public double profitRate(Lottos lottos, Lotto winningNumber) {
        lottos.matchedNumbers(winningNumber).forEach(this::savePrize);

        return (double) sumProfit() / lottos.investment();
    }

    private void savePrize(int matchingNumber) {
        Optional<PrizeCondition> prizeCondition = PrizeCondition.of(matchingNumber);
        prizeCondition.ifPresent(condition -> {
            Prize prize = prizes.get(condition).incrementedPrize();
            prizes.put(condition, prize);
        });
    }

    private int sumProfit() {
        int totalProfit = 0;

        for (Prize prize : prizes.values()) {
            totalProfit += prize.profit();
        }

        return totalProfit;
    }
}
