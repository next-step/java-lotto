package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public List<MatchResult> match(WinningLotto winningLotto) {
        List<MatchResult> matchResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningLotto.getNumbers());
            boolean isBonus = lotto.isBonus(winningLotto.getBonus());
            matchResults.add(new MatchResult(matchCount, isBonus));
        }

        return matchResults;
    }

    public List<Boolean> isBonus(WinningLotto winningLotto) {
        List<Boolean> isBonusess = new ArrayList<>();
        for (Lotto lotto : lottos) {
            isBonusess.add(lotto.isBonus(winningLotto.getBonus()));
        }

        return isBonusess;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
