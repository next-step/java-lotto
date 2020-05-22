package lotto.domain.prize;

import java.util.EnumMap;

public class LottoPrizeResult {

    private static final int DEFAULT_MATCHED_COUNT = 0;

    private final EnumMap<Prize, Integer> matchedPrizes;

    private LottoPrizeResult() {
        this.matchedPrizes = new EnumMap<>(Prize.class);
        for (Prize rank : Prize.values()) {
            matchedPrizes.put(rank, DEFAULT_MATCHED_COUNT);
        }
    }

    public static LottoPrizeResult init() {
        return new LottoPrizeResult();
    }

    public void updateMatchedPrize(final Prize prize) {
        matchedPrizes.put(prize, increasedMatchedTicketCount(prize));
    }

    private int increasedMatchedTicketCount(final Prize prize) {
        return this.getMatchedTicketCount(prize) + 1;
    }

    public float calculateProfitRate(final int purchaseAmount) {
        return ((float) this.calculateTotalPrizes() / purchaseAmount);
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
