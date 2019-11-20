package step4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoLottery {

    public static int bonusWinningCount = 0;
    public static boolean bonusCheck = false;
    public static int lottoBonusNumber;
    public static final int BONUS_WINNING_VALID_NUMBER = 5; // 2등 당첨을 위한(보너스볼 일치), 일치해야하는 로또번호 갯수

    private static List<Integer> bonusWinningIndex = new ArrayList<>();

    public static void updateBonusNumberIndex(Map<Integer, Integer> resultMatching, int key) {
        if (resultMatching.get(key) == BONUS_WINNING_VALID_NUMBER) {
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
                    LottoNumber.valueOf(eachLottoNumber.next()) == (lottoBonusNumber) ? bonusWinningCount + 1 : bonusWinningCount;
        }
        if (bonusWinningCount > 0) {
            bonusCheck = true;
        }
    }
}