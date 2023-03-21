package lotto;

import java.util.HashSet;

public class LottoGame {
    public static int match(Lotto userLotto, WinningLotto winningLotto) {
        int matchingCount = (int) userLotto
                .getLottoNumbers()
                .stream()
                .filter(it ->
                        winningLotto.getWinningNumber().getLottoNumbers().contains(it))
                .count();
        boolean bonusMatch = userLotto
                .getLottoNumbers()
                .contains(winningLotto.getBonusNumber());
        return LottoGame.winningCheck(matchingCount, bonusMatch);
    }
    public static int winningCheck(int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            return 1;
        }
        if (matchingCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchingCount == 5 ) {
            return 3;
        }
        if (matchingCount == 4) {
            return 4;
        }
        if (matchingCount ==3) {
            return 5;
        }
        return 6;
    }
}
