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

    public static int countMatchingNumbers(Set<Integer> winningNumbers, LottoNumbers userLottoNumbers) {
        List<Integer> userLottoNumberList = userLottoNumbers.getNumbers();

        return (int) userLottoNumberList.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static int getPrizeMoney(int matchCount) {
        return WinningPrize.getPrizeMoney(matchCount);
    }

    public static double calculateWinningRate(int money, int totalWinningAmount) {
        return (double) totalWinningAmount / money;
    }
}
