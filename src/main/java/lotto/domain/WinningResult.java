package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private static final int START_NUMBER = 3;
    private static final int END_NUMBER = 7;
    private static final int INITIAL_VALUE = 0;
    private static final int WINNING_CRITERIA = 3;
    private static final int CORRECT = 1;
    private static final int NOT_CORRECT = 0;

    private static final Map<Integer, Integer> RESULT_MAP = new LinkedHashMap<>() {
        {
            for (int i = START_NUMBER; i < END_NUMBER; i++) {
                put(i, INITIAL_VALUE);
            }
        }
    };

    private WinningResult() {
        throw new AssertionError();
    }

    public static Map<Integer, Integer> get(List<Integer> winningNumbers, LotteryGames lotteryGames) {
        for (LotteryGame lotteryGame : lotteryGames.getLotteryGames()) {
            int correctNumbers = getCorrectNumbers(winningNumbers, lotteryGame);

            if (correctNumbers < WINNING_CRITERIA) {
                continue;
            }

            RESULT_MAP.put(correctNumbers, RESULT_MAP.get(correctNumbers) + 1);
        }
        return RESULT_MAP;
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

    public static int profit(Map<Integer, Integer> results) {
        int profit = 0;
        for (Integer grade : results.keySet()) {
            profit += results.get(grade) * prize(grade);
        }
        return profit;
    }

    public static int prize(Integer grade) {
        switch (grade) {
            case 3: return 5000;
            case 4: return 50000;
            case 5: return 1500000;
            case 6: return 2000000000;
            default: throw new IllegalArgumentException();
        }
    }

    public static double profitRate(int profit, int spent) {
        return profit * 1.0 / spent;
    }
}
