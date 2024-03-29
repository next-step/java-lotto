package lotto;

import java.util.List;

public class LottoMatch {
    public static Rank match(List<Integer> lotto, List<Integer> winNumbers, int bonusNumber) {
        return Rank.valueOf(match(lotto, winNumbers), matchBonus(lotto, bonusNumber));
    }

    private static boolean matchBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public static int match(List<Integer> lotto, List<Integer> winNumbers) {
        int count = 0;

        for (int winNumber : winNumbers) {
            count += matchWinNumber(lotto, winNumber);
        }

        return count;
    }

    private static int matchWinNumber(List<Integer> lotto, int winNumber) {
        if (lotto.contains(winNumber)) {
            return 1;
        }
        return 0;
    }
}
