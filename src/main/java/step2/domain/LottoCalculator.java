package step2.domain;

import java.util.List;

public class LottoCalculator {
    private LottoCalculator() {
    }
    public static final int LOTTO_PRICE = 1000;

    public static int getCountOfLotto(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static double getTotalProfit(List<LottoNumber> lottos, LottoNumber winningNumbers, int purchaseAmount) {
        return calculateTotalProfit(lottos, winningNumbers) / purchaseAmount;
    }

    private static double calculateTotalProfit(List<LottoNumber> lottos, LottoNumber winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> LottoMatches.countMatchedNumbers(lotto, winningNumbers))
                .mapToDouble(matchedCount -> LottoRank.valueOf(matchedCount).getPrizeMoney())
                .sum();
    }
}
