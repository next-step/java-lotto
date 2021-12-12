package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> lottoResult;
    private final double profitRate;

    public LottoResult(Lottos lottos, Map<Integer, Integer> lottoResult) {
        this.lottoResult = lottoResult;
        this.profitRate = profitRate(lottos);
    }

    public int numberOfLotto(int matchedWinningCount) {
        return lottoResult.getOrDefault(matchedWinningCount, 0);
    }

    public double profitRate() {
        return profitRate;
    }

    private double profitRate(Lottos lottos) {
        double result = (double) totalWinningAmount() / lottos.amountOfLottos();
        return Math.floor(result * 100) / 100.0;
    }

    private int totalWinningAmount() {
        int sum = 0;
        for (int matchedWinningCount : lottoResult.keySet()) {
            sum = plusWinningAmount(sum, matchedWinningCount);
        }
        return sum;
    }

    private int plusWinningAmount(int sum, int matchedWinningCount) {
        int amount = Rank.winningAmount(matchedWinningCount);
        for (int i = 0; i < lottoResult.get(matchedWinningCount); i++) {
            sum += amount;
        }
        return sum;
    }

}
