package game.lotto.util;

import game.lotto.model.Lotto;
import game.lotto.model.Match;
import game.lotto.model.MatchResult;
import game.lotto.model.WinningLotto;

import java.util.List;

public class LottoMatcher {

    public static MatchResult match(WinningLotto winningLotto, List<Lotto> lottos) {
        MatchResult matchResult = new MatchResult();

        for (Lotto lotto : lottos) {
            Match match = winningLotto.match(lotto);
            matchResult.plus(match);
        }


        return matchResult;
    }
}
