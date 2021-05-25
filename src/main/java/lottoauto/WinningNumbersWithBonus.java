package lottoauto;

public class WinningNumbersWithBonus {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbersWithBonus(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isHitBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
