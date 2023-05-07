package step2.domain;

import java.util.List;

public class LottoCalculator {
    private LottoCalculator() {
    }

    public static final int[] PRIZES = {0, 0, 0, 5000, 500000, 15000000, 2000000000};
    public static final int LOTTO_PRICE = 1000;

    public static int getCountOfLotto(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static double getTotalProfit(List<List<Integer>> lottos, List<Integer> winningNumbers, int purchaseAmount) {
        return calculateTotalProfit(lottos, winningNumbers) / purchaseAmount;
    }

    private static double calculateTotalProfit(List<List<Integer>> lottos, List<Integer> winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> LottoMatches.countMatchedNumbers(lotto, winningNumbers))
                .mapToDouble(matchedCount -> PRIZES[matchedCount])
                .sum();
    }
}
