package step2.model;

public class Bonus {
    private final LottoNumber bonusNumber;

    public Bonus(WinningNumber winningNumbers, String bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
        isDuplicate(winningNumbers, this.bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void isDuplicate(WinningNumber winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.getWinningNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다. 다시 입력해주세요.");
        }
    }
}
