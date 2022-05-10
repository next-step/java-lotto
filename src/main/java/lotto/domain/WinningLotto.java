package lotto.domain;

public class WinningLotto {
    private static final String BONUS_BALL_CANNOT_CONTAIN_WINNING_LOTTO_NUMBERS_MESSAGE = "보너스 볼은 당첨 번호에 포함될 수 없습니다.";

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusBall) {
        checkContains(winningLottoNumbers, bonusBall);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    private void checkContains(LottoNumbers winningLottoNumbers, LottoNumber bonusBall) {
        if (winningLottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_CANNOT_CONTAIN_WINNING_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public LottoNumbers getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }

    public LottoNumber getBonusBall() {
        return this.bonusBall;
    }

    public boolean containsBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(this.bonusBall);
    }
}
