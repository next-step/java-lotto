package lotto.domain;

import java.util.List;

public class WinningCombo {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningCombo(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningCombo of(List<Integer> winningLotto, int bonusBall) {
        return new WinningCombo(Lotto.from(winningLotto), LottoNumber.from(bonusBall));
    }

    public Rank determinePrize(Lotto lotto) {
        int matchingCount = lotto.calculateSameNumber(winningLotto);
        boolean matchBonus = lotto.contain(bonusBall);

        return Rank.valueOf(matchingCount, matchBonus);
    }
}
