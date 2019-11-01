package step3;

import java.util.*;

public class LottoLottery {

    static int bonusWinningCount = 0;
    static boolean bonusCheck = false;

    private static List<Integer> bonusWinningIndex = new ArrayList<>();

    public static void updateBonusNumberIndex(Map<Integer, Integer> resultMatching, int key) {
        if (resultMatching.get(key) == LottoGenerator.BONUS_WINNING_VALID_NUMBER) {
            bonusWinningIndex.add(key);
        }
    }

    public static void purchasedLottoCompareBonusNumber(List<Integer> purchasedLotto, int indexCount) {
        if (bonusWinningIndex.contains(indexCount)) {
            bonusWinningCount = purchasedLotto.contains(LottoWinningNumbers.lottoBonusNumber) ? bonusWinningCount + 1 : bonusWinningCount;
        }

        if (bonusWinningCount > 0) {
            bonusCheck = true;
        }
    }
}