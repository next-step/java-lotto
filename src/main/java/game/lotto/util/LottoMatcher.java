package game.lotto.util;

import game.lotto.model.Lotto;
import game.lotto.model.LottoNumber;
import game.lotto.model.MatchResult;

import java.util.List;
import java.util.Set;

public class LottoMatcher {

    public static MatchResult match(Set<LottoNumber> winningNumbers, List<Lotto> lottos) {
        MatchResult matchResult = new MatchResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningNumbers);
            matchResult.incrementMatch(matchCount);
        }
        return matchResult;
    }
}
