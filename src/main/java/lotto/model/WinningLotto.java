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

    public Reward makeReward(Lotto lotto) {
        return Reward.makeReward(makeWinningCount(lotto), checkBonusCount(lotto));
    }

    private int makeWinningCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningLotto::contain)
                .count();
    }

    private boolean checkBonusCount(Lotto lotto) {
        return lotto.contain(this.bonusBall);
    }
}
