package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranks ranks(Lottos lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.rank(this));
        }
        return new Ranks(ranks);
    }

    public Rank rank(Lotto lotto) {
        if (lotto.isMatchFiveNumberAndBonusNumber(winningLotto, bonusNumber)) {
            return Rank.SECOND;
        }
        return Rank.of(lotto.matchCount(winningLotto));
    }
}
