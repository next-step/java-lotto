package lotto.util;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.WinningPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WinningUtils {

    private WinningUtils() {

    }

    public static LottoResult countMatchingNumbers(int bonusBall, Set<Integer> winningNumbers, LottoNumbers userLottoNumbers) {
        List<Integer> userLottoNumberList = userLottoNumbers.getNumbers();

        long matchCount = userLottoNumberList.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean isBonus = false;

        if (matchCount == 5 && userLottoNumberList.contains(bonusBall)) {
            isBonus = true;
        }
        return new LottoResult((int) matchCount, isBonus);
    }

    public static int getPrizeMoney(int matchCount, boolean isBonus) {
        return WinningPrize.getPrizeMoney(matchCount, isBonus);
    }

    public static double calculateWinningRate(int money, int totalWinningAmount) {
        return (double) totalWinningAmount / money;
    }
}
