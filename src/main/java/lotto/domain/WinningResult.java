package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private static final int INITIAL_VALUE = 0;
    private static final int WINNING_CRITERIA = 3;
    private static final int CORRECT = 1;
    private static final int NOT_CORRECT = 0;

    private static final Map<Rank, Integer> RESULT_MAP = new EnumMap<>(Rank.class) {
        {
            put(Rank.FIFTH, INITIAL_VALUE);
            put(Rank.FOURTH, INITIAL_VALUE);
            put(Rank.THIRD, INITIAL_VALUE);
            put(Rank.SECOND, INITIAL_VALUE);
            put(Rank.FIRST, INITIAL_VALUE);
        }
    };

    private WinningResult() {
        throw new AssertionError();
    }

    public static Map<Rank, Integer> get(List<Integer> winningNumbers, int bonusNumber,  LotteryGames lotteryGames) {
        for (LotteryGame lotteryGame : lotteryGames.getLotteryGames()) {
            int correctNumbers = getCorrectNumbers(winningNumbers, lotteryGame);

            if (isNotWin(correctNumbers) || isSecondRank(bonusNumber, lotteryGame, correctNumbers)) {
                continue;
            }

            Rank rank = Rank.valueOf(correctNumbers);
            RESULT_MAP.put(rank, RESULT_MAP.get(rank) + 1);
        }
        return RESULT_MAP;
    }

    private static boolean isNotWin(int correctNumbers) {
        return correctNumbers < WINNING_CRITERIA;
    }

    private static boolean isSecondRank(int bonusNumber, LotteryGame lotteryGame, int correctNumbers) {
        if (correctNumbers == 5) {
            return isContainedBonusNumber(bonusNumber, lotteryGame);
        }
        return false;
    }

    private static boolean isContainedBonusNumber(int bonusNumber, LotteryGame lotteryGame) {
        if (lotteryGame.isContain(bonusNumber)) {
            RESULT_MAP.put(Rank.SECOND, RESULT_MAP.get(Rank.SECOND) + 1);
            return true;
        }
        return false;
    }

    private static int getCorrectNumbers(List<Integer> winningNumbers, LotteryGame lotteryGame) {
        int correctNumbers = 0;
        for (Integer winningNumber : winningNumbers) {
            correctNumbers += getCorrectNumbers(lotteryGame, winningNumber);
        }
        return correctNumbers;
    }

    private static int getCorrectNumbers(LotteryGame lotteryGame, Integer winningNumber) {
        if (lotteryGame.isContain(winningNumber)) {
            return CORRECT;
        }
        return NOT_CORRECT;
    }

    public static int profit(Map<Rank, Integer> results) {
        int profit = 0;
        for (Rank rank : results.keySet()) {
            profit += results.get(rank) * rank.getWinningMoney();
        }
        return profit;
    }

    public static double profitRate(int profit, int spent) {
        return profit * 1.0 / spent;
    }
}
