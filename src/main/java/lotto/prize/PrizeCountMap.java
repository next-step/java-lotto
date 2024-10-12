package lotto.prize;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class PrizeCountMap {
    private static final int ZERO = 0;

    private final Map<LottoPrize, Integer> prizeCountMap;

    public PrizeCountMap() {
        prizeCountMap = new TreeMap<>();
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
        int totalCost = lottoTicketCount * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    private int calculateTotalPrize() {
        return prizeCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public Map<LottoPrize, Integer> getResults() {
        return prizeCountMap;
    }

}
