package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Lottos lottos;
    private final Map<Integer, Integer> lottoResult;

    public LottoResult(Lottos lottos, Map<Integer, Integer> lottoResult) {
        this.lottos = lottos;
        this.lottoResult = lottoResult;
    }

    public int numberOfLotto(int matchedWinningCount) {
        return lottoResult.getOrDefault(matchedWinningCount, 0);
    }

    public double profitRate() {
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
