package lotto.domain;

public class Winning {

    private static final String DUPLICATE_ERROR_MESSAGE = "마지막 보너스 볼은 당첨 번호에 포함될 수 없습니다.";
    private final LottoFullNumber winningLottoNumber;
    private final LottoNumber bonusLottoNumber;

    public Winning(final LottoFullNumber winningLottoNumber, final LottoNumber bonusLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
        this.bonusLottoNumber = bonusLottoNumber;
        validationWinningNumber();
    }


    private void validationWinningNumber() {
        if (winningLottoNumber.getLottoFullNumber().contains(bonusLottoNumber.getValue())) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
