package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculation {
    private static final Map<WinningType, Integer> matchResult = new HashMap<>();

    public static Map<WinningType, Integer> calculateResult(WinningLotto winningLotto, List<Lotto> lottos) {
        initialMatchResult();

        for (Lotto lotto : lottos) {
            int count = winningBallMatchNumber(winningLotto, lotto);
            boolean isBonusBall = hasBonusBall(winningLotto.getBonusBall(), lotto.getLottoNumbers());

            WinningType winningType = WinningType.match(count, isBonusBall); // 이넘타입 반환

            updateCount(winningType);
        }

        return matchResult;
    }

    private static void initialMatchResult() {
        matchResult.put(WinningType.THREE, 0);
        matchResult.put(WinningType.FOUR, 0);
        matchResult.put(WinningType.FIVE, 0);
        matchResult.put(WinningType.FIVE_BONUS, 0);
        matchResult.put(WinningType.SIX, 0);
    }

    private static void updateCount(WinningType winningType) {
        if (winningType.getValue() != 0) {
            matchResult.put(winningType, matchResult.get(winningType) + 1);
        }
    }

    public static int winningBallMatchNumber(WinningLotto winningLotto, Lotto lotto) {
        return (int) winningLotto.getWinningLottoNumbers()
                .stream()
                .filter(lotto.getLottoNumbers()::contains)
                .count();
    }

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

    public static Boolean hasBonusBall(int bonusBall, List<Integer> lotto) {
        return lotto.contains(bonusBall);
    }
}
