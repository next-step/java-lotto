package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private static final int INITIAL_VALUE = 0;
    private static final double TO_DOUBLE = 1.0;
    private static final Map<Rank, Integer> RESULT_MAP = new EnumMap<>(Rank.class) {
        {
            put(Rank.FIFTH, INITIAL_VALUE);
            put(Rank.FOURTH, INITIAL_VALUE);
            put(Rank.THIRD, INITIAL_VALUE);
            put(Rank.SECOND, INITIAL_VALUE);
            put(Rank.FIRST, INITIAL_VALUE);
            put(Rank.MISS, INITIAL_VALUE);
        }
    };

    private WinningData winningData;
    private LotteryGames lotteryGames;

    public WinningResult(WinningNumbers winningNumbers, int bonusNumber, LotteryGames lotteryGames) {
        this(new WinningData(winningNumbers, bonusNumber), lotteryGames);
    }

    public WinningResult(WinningData winningData, LotteryGames lotteryGames) {
        this.winningData = winningData;
        this.lotteryGames = lotteryGames;
    }

    public Map<Rank, Integer> get() {
        for (LotteryGame lotteryGame : lotteryGames.getLotteryGames()) {
            Rank rank = winningData.matchNumbers(lotteryGame);
            RESULT_MAP.put(rank, RESULT_MAP.get(rank) + 1);
        }
        return RESULT_MAP;
    }

    public int profit(Map<Rank, Integer> results) {
        int profit = 0;
        for (Rank rank : results.keySet()) {
            profit += results.get(rank) * rank.getWinningMoney();
        }
        return profit;
    }

    public double profitRate(int profit, int spent) {
        return profit * TO_DOUBLE / spent;
    }
}
