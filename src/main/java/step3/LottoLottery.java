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

    public static void purchasedLottoCompareBonusNumber(List<LottoNumber> purchasedLotto, int indexCount) {
        if (bonusWinningIndex.contains(indexCount)) {
            Iterator<LottoNumber> iter = purchasedLotto.iterator();
            compareBonusNumber(iter);
        }
    }

    private static void compareBonusNumber(Iterator<LottoNumber> eachLottoNumber) {
        while (eachLottoNumber.hasNext()) {
            bonusWinningCount =
                    LottoNumber.valueOf(eachLottoNumber.next()) == (LottoNumber.lottoBonusNumber) ? bonusWinningCount + 1 : bonusWinningCount;
        }
        if (bonusWinningCount > 0) {
            bonusCheck = true;
        }
    }
}