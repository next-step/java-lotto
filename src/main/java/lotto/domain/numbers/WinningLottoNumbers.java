package lotto.domain.numbers;

public class WinningLottoNumbers {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(final LottoTicket winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return winningNumbers.isContain(lottoNumber);
    }

    public boolean isMatchBonusNumber(final LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    private void validateBonusNumber(LottoNumber bonusNumber) {
        if (winningNumbers.isContain(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호 6개에 보너스 숫자가 포함 되어 있으면 안됩니다.");
        }
    }
}
