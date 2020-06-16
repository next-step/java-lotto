package lotto.domain;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }

    public static WinningNumbers of(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasNumber(LottoNumber number) {
        return winningNumbers.contains(number);
    }
}
