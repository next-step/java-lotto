package lotto.service;

import lotto.common.Prize;
import lotto.model.Lotto;

import java.util.List;

public class LottoAnalyzer {

    private LottoAnalyzer() {
    }

    public static int[] calculateWinningStatics(List<Integer> winningNumbers, List<Lotto> lottos) {
        int[] winningStatics = new int[7];

        for (Lotto lotto : lottos) {
            int matchingNumberCount = lotto.countMatchingNumber(winningNumbers);
            winningStatics[matchingNumberCount]++;
        }

        return winningStatics;
    }

    public static float calculateReturnRate(int buyAmount, int[] winningStatics) {
        int totalPrize = calculatePrize(winningStatics);

        return (float) totalPrize / buyAmount;
    }

    private static int calculatePrize(int[] winningStatics) {
        int totalPrize = 0;

        for (int count = 3; count <= 6; count++) {
            totalPrize += winningStatics[count] * Prize.PRIZE[count];
        }

        return totalPrize;
    }
}
