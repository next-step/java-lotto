package lotto.domain;

public class WinningNumber {

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        validateWinningNumber(winningNumber);
        validateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto winningNumber() {
        return winningNumber;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumber(Lotto winningNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }
    }

    private void validateBonusNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }

        if (winningNumber.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 번호와 중복되는 번호가 들어가 있습니다.");
        }
    }
}
