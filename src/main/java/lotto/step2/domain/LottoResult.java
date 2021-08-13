package lotto.step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int MULTIPLE_FIRST_PLACE_WINNING = 2;

    private Map<WinningRank, Integer> lottoResult;

    public LottoResult(Map<WinningRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

    public Map<WinningRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public double calculateStatistics(int money) {
        long sum = 0;
        for (WinningRank rank : WinningRank.values()) {
            sum += rank.getWinnings()* lottoResult.getOrDefault(rank,0);
        }
        return sum / (double) money;
    }

    public int addLottoWinnings(WinningRank winningRank) {
        if (winningRank.toString().equals("FIRST_PLACE")) {
            return winFirstRank(winningRank);
        }
        return winningRank.getWinnings() * lottoResult.getOrDefault(winningRank, 0);
    }

    public int winFirstRank(WinningRank winningRank) {
        if (lottoResult.getOrDefault(winningRank, 0) >= MULTIPLE_FIRST_PLACE_WINNING) {
            return winningRank.getWinnings();
        }
        return winningRank.getWinnings() * lottoResult.getOrDefault(winningRank, 0);
    }

}
