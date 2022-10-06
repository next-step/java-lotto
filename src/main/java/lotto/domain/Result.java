package lotto.domain;

import lotto.enumerate.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Result {
    private final Map<Rank, WinResult> winResultMap = new EnumMap<>(Rank.class);
    private int initMoney;

    public Result(List<Lotto> lottos, List<Integer> lastWeeksCollectNumberList, int bonusNumber) {
        this.saveInitMoney(lottos.size());
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(lastWeeksCollectNumberList);
            boolean matchToBonusNumber = lotto.isMatchToBonusNumber(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchToBonusNumber);
            this.saveResult(rank);
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
