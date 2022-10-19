package step2.domain;

public class BonusLottoNumber extends LottoNumberElement {

    public BonusLottoNumber(int bonusNumber, LottoNumber winNumber) {
        super(bonusNumber);
        validateDuplicateWinLottoNumber(winNumber);
    }

    private void validateDuplicateWinLottoNumber(LottoNumber winNumber) {
        if (winNumber.isInclude(this)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같을 수 없습니다. 당첨번호: " + winNumber + " |입력한 보너스 번호: " + lottoNumberElement);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.lottoNumberElement);
    }
}
