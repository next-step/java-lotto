package step3;

import java.util.*;

public class LottoLottery {

    static int BONUS_WINNING_COUNT = 0;
    static boolean bonusCheck = false;

    private static List<Integer> bonusWinningIndex = new ArrayList<>();

    public static void updateBonusNumberIndex(Map<Integer, Integer> resultMatching, int key) {
        if (resultMatching.get(key) == LottoGenerator.BONUS_WINNING_VALID_NUMBER) {
            bonusWinningIndex.add(key);
        }
    }

    public static void purchasedLottoCompareBonusNumber(List<Integer> purchasedLotto, int indexCount) {
        if (bonusWinningIndex.contains(indexCount)) {
            BONUS_WINNING_COUNT = purchasedLotto.contains(LottoWinningNumbers.LOTTO_BONUS_NUMBER) ? BONUS_WINNING_COUNT + 1 : BONUS_WINNING_COUNT;
        }

        if (BONUS_WINNING_COUNT > 0) {
            bonusCheck = true;
        }
    }
}