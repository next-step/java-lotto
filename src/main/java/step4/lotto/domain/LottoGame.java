package step4.lotto.domain;

import java.util.List;

public class LottoGame {

    public static Rank match(List<Integer> userLotto, List<Integer> winningLotto, int bonusNumber){

        Lotto user = new Lotto(userLotto);
        Lotto winning = new Lotto(winningLotto);

        int matchCount = user.match(winning);
        boolean matchBonus = user.contains(bonusNumber);
        return Rank.rank(matchCount,matchBonus);
    }

}
