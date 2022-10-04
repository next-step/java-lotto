package lotto.domain;

import lotto.enumerate.Rank;

import java.util.*;

public class Result {
    private final Map<Rank, WinResult> winResultMap = new HashMap<>();
    private int initMoney;

    public Result(List<Lotto> lottos, List<Integer> lastWeeksCollectNumberList, int bonusNumber) {
        this.saveInitMoney(lottos.size());
        for (Lotto lotto : lottos) {
            this.saveResult(Rank.valueOf(lotto.getMatchCount(lastWeeksCollectNumberList), lotto.isMatchToBonusNumber(bonusNumber)));
        }
    }

    public double getRateOfIncome() {
        return ((double) (int) (((double) getTotalIncome() / (double) this.initMoney) * 100) / 100);
    }

    public int getWinCount(Rank rank) {
        return Optional.of(this.winResultMap)
                .map(vo -> vo.get(rank))
                .map(WinResult::getWinCount)
                .orElse(0);
    }

    private int getTotalIncome() {
        int sum = 0;
        for (WinResult winResult : this.winResultMap.values()) {
            sum += winResult.getRank().getWinningMoney() * winResult.getWinCount();
        }
        return sum;
    }

    private void saveInitMoney(int lottoCount) {
        this.initMoney = lottoCount * Config.LOTTO_PRICE;
    }

    private void saveResult(Rank rank) {
        if (rank == null) {
            return;
        }

        winResultMap.putIfAbsent(rank, new WinResult(rank));
        winResultMap.get(rank).addWinCount();
    }

    private class WinResult {
        private final Rank rank;
        private int winCount = 0;

        private WinResult(Rank rank) {
            this.rank = rank;
        }

        private Rank getRank() {
            return rank;
        }

        private int getWinCount() {
            return winCount;
        }

        private void addWinCount() {
            this.winCount++;
        }
    }

}
