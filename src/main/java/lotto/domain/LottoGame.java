package lotto.domain;

import java.util.List;

public class LottoGame {
    public static int match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNo) {
        int matchCount = match(userLotto, winningLotto);
        if (matchCount == 6) {
            return 1;
        }
        boolean matchBonus = userLotto.contains(bonusNo);
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }

    private static int match(List<Integer> userLotto, List<Integer> winningLotto) {
        int count = 0;
        for (Integer lottoNumber : userLotto) {
            if (winningLotto.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }
}
