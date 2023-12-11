package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.winningLotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank rank(Lotto lotto) {
        int matchCount = lotto.match(winningLotto);
        Boolean matchBonus = lotto.matchBonus(bonusNo);
        if (matchBonus) {
            matchCount++;
        }
        return Rank.rank(matchCount, matchBonus);
    }

    public Lotto getLotto() {
        return winningLotto;
    }

}
