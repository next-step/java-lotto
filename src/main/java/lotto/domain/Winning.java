package lotto.domain;

public class Winning {

    private static final String DUPLICATE_ERROR_MESSAGE = "마지막 보너스 볼은 당첨 번호에 포함될 수 없습니다.";
    private final Lotto winningLottoNumber;
    private final LottoNumber bonusLottoNumber;

    public Winning(final Lotto winningLottoNumber, final LottoNumber bonusLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
        this.bonusLottoNumber = bonusLottoNumber;
        validationWinningNumber();
    }


    private void validationWinningNumber() {
        if (winningLottoNumber.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public long winningLottoNumber(Lotto lotto) {
        return winningLottoNumber.countMatch(lotto);
    }

    public boolean bonusLottoNumber(Lotto lotto) {
        return lotto.contains(bonusLottoNumber);
    }

}
