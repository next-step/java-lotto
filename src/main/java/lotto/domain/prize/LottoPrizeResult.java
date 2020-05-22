package lotto.domain.prize;

import lotto.domain.price.Price;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class LottoPrizeResult {

    private static final int DEFAULT_MATCHED_COUNT = 0;

    private final Price price;
    private final EnumMap<Prize, Integer> matchedPrizes;

    private LottoPrizeResult(final Price price, final Map<Prize, Long> prizes) {
        this.price = price;
        this.matchedPrizes = new EnumMap<>(Prize.class);
        EnumSet.allOf(Prize.class)
                .forEach(prize ->
                    matchedPrizes.put(prize, Math.toIntExact(prizes.getOrDefault(prize, (long) DEFAULT_MATCHED_COUNT)))
                );
    }

    public static LottoPrizeResult init(final Price price, final Map<Prize, Long> prizes) {
        return new LottoPrizeResult(price, prizes);
    }

    public float calculateProfitRate() {
        return this.price.calculateProfitRate(calculateTotalPrizes());
    }

    private int calculateTotalPrizes() {
        return matchedPrizes.keySet()
                .stream()
                .mapToInt(this::calculatePrizes)
                .sum();
    }

    private int calculatePrizes(final Prize prize) {
        return prize.getPrizeMoney() * this.getMatchedTicketCount(prize);
    }

    public int getMatchedTicketCount(final Prize prize) {
        return this.matchedPrizes.get(prize);
    }

    public EnumMap<Prize, Integer> getMatchedPrizes() {
        return matchedPrizes;
    }
}
