package step2.domain;

public class BonusNumber implements LottoNumberRange {
    private final int bonusNumber;
    public BonusNumber(int bonusNumber, LottoNumber winNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateWinLottoNumber(bonusNumber, winNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateWinLottoNumber(int bonusNumber, LottoNumber winNumber) {
        if (winNumber.isInclude(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같을 수 없습니다. 당첨번호: " + winNumber + " |입력한 보너스 번호: " + bonusNumber);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(bonusNumber);
    }
}
