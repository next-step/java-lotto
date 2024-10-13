package lotto.prize;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class PrizeCountMap {
    private static final int ZERO = 0;

    private final EnumMap<LottoPrize, Integer> prizeCountMap;

    public PrizeCountMap() {
        prizeCountMap = new EnumMap<>(LottoPrize.class);
        initPrizeCountMap();
    }

    private void initPrizeCountMap() {
        Arrays.stream(LottoPrize.values())
                .forEach(prizeCount -> prizeCountMap.put(prizeCount, ZERO));
    }

    public void increasePrizeCount(int matchedLottoNumbers, boolean matchedBonus) {
        LottoPrize prize = LottoPrize.getPrize(matchedLottoNumbers, matchedBonus);
        prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, ZERO) + 1);
    }

    public double calculateProfitRate(int lottoTicketCount) {
        long totalCost = (long) lottoTicketCount * LOTTO_PRICE;
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    private long calculateTotalPrize() {
        return prizeCountMap.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public Map<LottoPrize, Integer> getResults() {
        return prizeCountMap;
    }

}
