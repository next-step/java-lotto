package step2_pobi.domain;

import java.util.List;

public class LottoGame {

    public static Rank match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNo) {
        Lotto newUserLotto = new Lotto(userLotto);
        int matchCount = newUserLotto.match(new Lotto(winningLotto));
        boolean matchBonus = newUserLotto.contains(LottoNumber.of(bonusNo));
        return Rank.rank(matchCount, matchBonus);
    }

    public static Rank match(List<Integer> userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }
}
