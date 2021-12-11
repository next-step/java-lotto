package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Lottos lottos;
    private final Lotto winningNumbers;
    private final Map<Integer, Integer> lottoResult;

    public LottoResult(Lottos lottos, Lotto winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.lottoResult = init();
    }

    private Map<Integer, Integer> init() {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos.lottos()) {
            int matchedCount = lotto.matchedCount(winningNumbers);
            lottoResult.put(matchedCount, lottoResult.getOrDefault(matchedCount, 0) + 1);
        }
        return lottoResult;
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
