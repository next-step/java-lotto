package game.lotto.util;

import game.lotto.model.Lotto;
import game.lotto.model.MatchResult;

import java.util.List;

public class LottoMatcher {

    public static MatchResult match(Lotto target, List<Lotto> lottos) {
        MatchResult matchResult = new MatchResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(target);
            matchResult.incrementMatch(matchCount);
        }
        return matchResult;
    }
}
