package lotto.domain;

import java.util.List;

public class LottoGame {
    public List<Integer> userLotto;
    public List<Integer> winningLotto;
    int bonusNumber;
    
    public static int match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNumber) {
        int matchCount = match(userLotto, winningLotto);
        if (matchCount == 6) {
            return 1;
        }
        boolean matchBonus = userLotto.contains(bonusNumber);
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }

    private static int match(List<Integer> userLotto, List<Integer> winningLotto) {
        return 0;
    }
}
