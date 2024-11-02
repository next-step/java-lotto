package lotto.util;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.WinningPrize;

import java.util.List;
import java.util.stream.Collectors;

public class WinningUtils {

    private WinningUtils() {

    }

    public static LottoResult countMatchingNumbers(List<Integer> winningNumbers, LottoNumbers userLottoNumbers) {
        int bonusBall = winningNumbers.stream().reduce((first, second) -> second).orElse(-1);

        List<Integer> winningCopyList = winningNumbers.stream().collect(Collectors.toList());
        winningCopyList.remove(winningNumbers.size() - 1);

        List<Integer> userLottoNumberList = userLottoNumbers.getNumbers();

        long matchCount = userLottoNumberList.stream()
                .filter(winningCopyList::contains)
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
