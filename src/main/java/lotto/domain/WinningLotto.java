package lotto.domain;

public class WinningLotto {
    private static final String BONUS_NUMBER_CONTAINS_ERROR = "보너스 번호는 당첨 번호에 포함되지 않아야 합니다.";

    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String winningLottoString, int bonus) {
        this.winningLotto = LottoBox.parseNumberString(winningLottoString);
        LottoNumber bonusNumber = new LottoNumber(bonus);
        checkBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumber(LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_CONTAINS_ERROR);
        }
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.getRank(lotto.matchCount(winningLotto), lotto.contains(bonusNumber));
    }
}
