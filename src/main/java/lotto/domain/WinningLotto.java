package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        containSameNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void containSameNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("이미 당첨번호에 있습니다.");
        }
    }

    public static WinningLotto init(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Statistics matchingLotto(Lotto lotto) {
        int matchingBall = lotto.findMatchingBall(winningLotto);
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        return Statistics.init(matchingBall, hasBonusNumber);
    }
}
