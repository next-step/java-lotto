package lotto.service;

import java.util.List;

public class LottoWinningStaticsCalculator {
    private static final int[] PRIZE = {0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000};

    private LottoWinningStaticsCalculator() {
    }

    public static int[] calculateWinningStatics(List<Integer> winningNumbers, List<Integer>[] lottos) {
        int[] winningStatics = new int[7];

        for (List<Integer> lotto : lottos) {
            int matchingNumberCount = countMatchingNumbers(winningNumbers, lotto);
            winningStatics[matchingNumberCount]++;
        }

        return winningStatics;
    }

    public static int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> lotto) {
        return (int) lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static float calculateReturnRate(int purchaseAmount, int[] winningStatics) {
        int totalPrize = calculatePrize(winningStatics);

        return (float) totalPrize / purchaseAmount;
    }

    public static int calculatePrize(int[] winningStatics) {
        int totalPrize = 0;

        for (int count = 3; count <= 6; count++) {
            totalPrize += winningStatics[count] * PRIZE[count];
        }

        return totalPrize;
    }
}
