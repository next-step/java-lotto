package lotto.domain;

import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonus;
    public WinningLotto(String lotto, int bonus) {
        this.winningLotto = new Lotto(lotto);
        this.bonus = new LottoNumber(bonus);
    }

    public WinningLotto(String lotto, String bonus) {
        this(lotto, Integer.parseInt(bonus));
    }

    public LottoResult getResult(Lotto lotto) {
        int matchCount = lotto.hitCount(winningLotto);
        boolean matchBonus = lotto.contains(bonus);
        return LottoResult.of(matchCount, matchBonus);
    }
}
