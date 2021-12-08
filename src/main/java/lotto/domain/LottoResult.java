package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> lottoResult;

    public LottoResult(Map<Integer, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void add(int matchedWinningCount) {
        lottoResult.put(matchedWinningCount, lottoResult.getOrDefault(matchedWinningCount, 0) + 1);
    }

    public int numberOfLotto(int matchedWinningCount) {
        return lottoResult.getOrDefault(matchedWinningCount, 0);
    }

    public int totalWinningAmount(Map<Integer, Integer> winningStandard) {
        int sum = 0;
        for (int matchedWinningCount : lottoResult.keySet()) {
            int winningAmount = winningStandard.getOrDefault(matchedWinningCount, 0);
            sum += winningAmount;
        }
        return sum;
    }


}
