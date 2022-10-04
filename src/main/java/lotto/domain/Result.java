package lotto.domain;

import java.util.*;

public class Result {
    private final Map<Integer, WinResult> winResultMap = new HashMap<>();
    private int initMoney;

    public Result(List<Lotto> lottos, List<Integer> lastWeeksCollectNumberList) {
        this.saveInitMoney(lottos.size());
        for (Lotto lotto : lottos) {
            this.saveResult(lotto.getMatchCount(lastWeeksCollectNumberList));
        }
    }

    public double getRateOfIncome() {
        return ((double) (int) (((double) getTotalIncome() / (double) this.initMoney) * 100) / 100);
    }

    public int getWinCount(int matchingCount) {
        return Optional.of(this.winResultMap)
                .map(vo -> vo.get(matchingCount))
                .map(WinResult::getWinCount)
                .orElse(0);
    }

    private boolean isWin(int matchingCount) {
        return Reward.getReward(matchingCount) != 0;
    }

    private int getTotalIncome() {
        int sum = 0;
        for (WinResult winResult : this.winResultMap.values()) {
            sum += Reward.getReward(winResult.getMatchingCount()) * winResult.getWinCount();
        }
        return sum;
    }

    private void saveInitMoney(int lottoCount) {
        this.initMoney = lottoCount * Config.LOTTE_PRICE;
    }

    private void saveResult(int matchingCount) {
        if (isWin(matchingCount)) {
            winResultMap.putIfAbsent(matchingCount, new WinResult(matchingCount));
            winResultMap.get(matchingCount).addWinCount();
        }
    }

    private class WinResult {
        private final int matchingCount;
        private int winCount = 0;

        private WinResult(int matchingCount) {
            this.matchingCount = matchingCount;
        }

        private int getMatchingCount() {
            return matchingCount;
        }

        private int getWinCount() {
            return winCount;
        }

        private void addWinCount() {
            this.winCount++;
        }
    }

}
