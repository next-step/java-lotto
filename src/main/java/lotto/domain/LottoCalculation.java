package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculation {





    public static float getProfitRate(Map<WinningType, Integer> result, int money) {
        int totalProfit = 0;

        for (WinningType key : result.keySet()) {
            Integer value = result.get((key));
            totalProfit += key.getProfit() * value;
        }

        return (float) totalProfit / (float) money;
    }

    public Boolean isWinningBall(int number, List<Integer> winningBalls) {
        return winningBalls.contains(number);
    }


}
