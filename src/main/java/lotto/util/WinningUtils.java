package lotto.util;

import lotto.domain.LottoNumbers;
import lotto.domain.WinningPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WinningUtils {

    private WinningUtils() {

    }

    public static int countMatchingNumbers(Set<Integer> lottoNumbers, LottoNumbers winningNumbers) {
        int matchCount = 0;

        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);

        List<Integer> sortedWinningNumvers = winningNumbers.getNumbers();

        int minSize = Math.min(sortedLottoNumbers.size(), sortedLottoNumbers.size());

        for (int i = 0; i < minSize; i++) {
            if (sortedLottoNumbers.get(i).equals(sortedWinningNumvers.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static int getPrizeMoney(int matchCount) {
        return WinningPrize.getPrizeMoney(matchCount);
    }

    public static double calculateWinningRate(int money, int totalWinningAmount) {
        return (double) totalWinningAmount / money;
    }
}
