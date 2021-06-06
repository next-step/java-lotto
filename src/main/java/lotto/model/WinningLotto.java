package lotto.model;

import java.util.Set;

public class WinningLotto {
    private static final String BONUS_BALL_CONTAIN_LOTTO_NUMBER_MESSAGE = "로또넘버와 보너스볼은 중첩 될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        validateBonusBallNotContainLottoNumbers(lottoNumbers, bonusBall);
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusBall = bonusBall;
    }

    private void validateBonusBallNotContainLottoNumbers(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_CONTAIN_LOTTO_NUMBER_MESSAGE);
        }
    }

    public WinningState makeWinningState(Lotto lotto) {
        int winningCount = makeWinningCount(lotto.getLottoNumbers(), getLottoNumbers());
        WinningState winningState = new WinningState(winningCount, checkBonusCount(lotto, this.bonusBall));

        return winningState;
    }

    private int makeWinningCount(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter((lottoNumber) -> winningLottoNumbers.contains(lottoNumber))
                .count();
    }

    private boolean checkBonusCount(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contain(bonusNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }
}
