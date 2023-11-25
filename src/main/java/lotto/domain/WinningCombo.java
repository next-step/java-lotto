package lotto.domain;

import java.util.List;

public class WinningCombo {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    private WinningCombo(Lotto winningLotto, LottoNumber bonusBall) {
        validateDuplicates(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningCombo of(Lotto winningLotto, LottoNumber bonusBall) {
        return new WinningCombo(winningLotto, bonusBall);
    }

    public static WinningCombo of(List<Integer> winningLotto, int bonusBall) {
        return new WinningCombo(Lotto.from(winningLotto), LottoNumber.from(bonusBall));
    }

    public Rank determinePrize(Lotto lotto) {
        int matchingCount = lotto.calculateSameNumber(winningLotto);
        boolean matchBonus = lotto.contain(bonusBall);

        return Rank.valueOf(matchingCount, matchBonus);
    }

    private void validateDuplicates(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contain(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
