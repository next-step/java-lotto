package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    public static final int ONE_GAME_MONEY = 1000;
    public static final int GAME_COUNT_ZERO = 0;
    private Map<Rank, Integer> lottoResult = new HashMap<>();;

    public void calculateWinningResult(List<LottoPaper> buyLotto, WinningLottoNumber winningLottoNumber) {
        for (LottoPaper lotto : buyLotto) {
            int matchCount = lotto.checkMatchNumberCount(winningLottoNumber.getWinningNumber());
            calculateRank(Rank.valueOf(matchCount));
        }
    }

    private void calculateRank(Rank rank) {
        lottoResult.put(rank, lottoResult.getOrDefault(rank, GAME_COUNT_ZERO) + 1);
    }

    public int winningCount(Rank rankStatus) {
        return lottoResult.getOrDefault(rankStatus, GAME_COUNT_ZERO);
    }

    public double earnMoneyRate() {
        return (double) getEarnMoney() / (getMatchCount() * ONE_GAME_MONEY);
    }

    public long getEarnMoney() {
        int earnMoney = 0;

        for (Rank rank : Rank.values()) {
            earnMoney += lottoResult.getOrDefault(rank, GAME_COUNT_ZERO) * rank.getWinningMoney();
        }

        return earnMoney;
    }

    public int getMatchCount() {
        int matchCount = 0;

        for (Rank rank : Rank.values()) {
            matchCount += lottoResult.getOrDefault(rank, GAME_COUNT_ZERO);
        }

        return matchCount;
    }

}
