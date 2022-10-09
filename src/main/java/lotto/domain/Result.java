package lotto.domain;

import lotto.enumerate.Rank;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Result {
    private final Map<Rank, WinResult> winResultMap = new EnumMap<>(Rank.class);
    private int initMoney;

    public Result(LottoWrapper lottoWrapper, LottoNumbersWrapper lastWeeksCollectNumbers, int bonusNumber) {
        this.saveInitMoney(lottoWrapper.getLottoCount());
        for (Rank rank : lottoWrapper.getResultRanks(lastWeeksCollectNumbers, bonusNumber)) {
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
