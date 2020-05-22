package lotto.domain.prize;

import lotto.domain.Price;

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
                .forEach(prize -> {
                    if (!prizes.containsKey(prize)) {
                        matchedPrizes.put(prize, DEFAULT_MATCHED_COUNT);
                        return;
                    }
                    matchedPrizes.put(prize, prizes.get(prize).intValue());
                });
    }

    public static LottoPrizeResult init(final Price price, final Map<Prize, Long> prizes) {
        return new LottoPrizeResult(price, prizes);
    }

    public void updateMatchedPrize(final Prize prize) {
        matchedPrizes.put(prize, increasedMatchedTicketCount(prize));
    }

    private int increasedMatchedTicketCount(final Prize prize) {
        return this.getMatchedTicketCount(prize) + 1;
    }

    public float calculateProfitRate() {
        return ((float) this.calculateTotalPrizes() / price.getPrice());
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

    private int getMatchedTicketCount(final Prize prize) {
        return this.matchedPrizes.get(prize);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        matchedPrizes.keySet()
                .forEach(prize ->
                    stringBuilder.append(prize.toString())
                            .append(String.format(" - %d개", matchedPrizes.get(prize)))
                            .append("\n"));
        return stringBuilder.toString();
    }
}
