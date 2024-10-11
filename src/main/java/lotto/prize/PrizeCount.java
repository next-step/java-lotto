package lotto.prize;

import lotto.number.LottoBalls;

import java.util.Map;
import java.util.TreeMap;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class PrizeCount {
    private static final int ZERO = 0;

    private final Map<Integer, Integer> prizeCountMap;

    public PrizeCount() {
        prizeCountMap = new TreeMap<>();
        initPrizeCountMap();
    }

    private void initPrizeCountMap() {
        for (int numberOfMatched = 0; numberOfMatched <= LottoBalls.NUMBER_OF_BALLS; numberOfMatched++) {
            prizeCountMap.put(numberOfMatched, ZERO);
        }
    }

    public void increasePrizeCount(int matchedLottoNumbers) {
        prizeCountMap.put(matchedLottoNumbers, prizeCountMap.getOrDefault(matchedLottoNumbers, ZERO) + 1);
    }

    public int calculateTotalPrize() {
        return prizeCountMap.entrySet().stream()
                .mapToInt(entry -> LottoPrize.getPrizeAmount(entry.getKey()) * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(int lottoTicketCount) {
        int totalCost = lottoTicketCount * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / totalCost;
    }

    public Map<Integer, Integer> getResults() {
        return prizeCountMap;
    }
}
