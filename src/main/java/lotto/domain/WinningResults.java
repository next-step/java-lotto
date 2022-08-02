package lotto.domain;

import lotto.interfaces.LotteryGame;
import lotto.interfaces.LotteryResult;

import java.util.EnumMap;
import java.util.Map;

public class WinningResults implements LotteryResult {
    private static final int INITIAL_VALUE = 0;
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
    private static final double TO_DOUBLE = 1.0;

    private final LotteryGames lotteryGames;
    private final WinningNumbers winningNumbers;

    public WinningResults(LotteryGames lotteryGames, WinningNumbers winningNumbers) {
        this.lotteryGames = lotteryGames;
        this.winningNumbers = winningNumbers;
    }

    @Override
    public Map<Rank, Integer> result() {
        for (LotteryGame lotteryGame : lotteryGames.getLotteryGameList()) {
            WinningResult winningResult = new WinningResult(lotteryGame, winningNumbers);
            Rank result = winningResult.result();
            RESULT_MAP.put(result, RESULT_MAP.get(result) + 1);
        }
        return RESULT_MAP;
    }

    @Override
    public double profit(Map<Rank, Integer> results, int spent) {
        int profit = 0;
        for (Rank rank : results.keySet()) {
            profit += results.get(rank) * rank.getWinningMoney();
        }
        return profit * TO_DOUBLE / spent;
    }
}