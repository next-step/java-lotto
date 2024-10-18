package lotto.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStaticsCalculator {
    private static final int[] PRIZE = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private LottoWinningStaticsCalculator() {
    }

    public static Map<Integer, Integer> calculateWinningStatics(List<Integer> winningNumbers, Map<Integer, List<Integer>> lottos) {
        Map<Integer, Integer> winningStatics = initializeStaticsMap();

        for (int count = 1; count <= lottos.size(); count++) {
            List<Integer> lotto = lottos.get(count);

            int matchingNumberCount = countMatchingNumbers(winningNumbers, lotto);
            winningStatics.put(matchingNumberCount, winningStatics.get(matchingNumberCount) + 1);
        }

        return winningStatics;
    }

    private static Map<Integer, Integer> initializeStaticsMap() {
        Map<Integer, Integer> winningStatics = new HashMap<>();

        for (int count = 0; count <= 6; count++) {
            winningStatics.put(count, 0);
        }

        return winningStatics;
    }

    public static int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> lotto) {
        return (int) lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static float calculateReturnRate(int purchaseAmount, Map<Integer, Integer> winningStatics) {
        int totalPrize = calculatePrize(winningStatics);

        return (float) totalPrize / purchaseAmount;
    }

    private static int calculatePrize(Map<Integer, Integer> winningStatics) {
        int totalPrize = 0;

        for (int count = 3; count <= 6; count++) {
            totalPrize += winningStatics.get(count) * PRIZE[count];
        }

        return totalPrize;
    }
}
