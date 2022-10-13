package lotto.domain;

public class WinningNumber {

    private final static int COUNTS_OF_LOTTO_NUMBER = 6;

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

        if (winningNumber.lottoNumbers().size() != COUNTS_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6자리로 이루어져 있어야 합니다.");
        }
    }

    private void validateBonusNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }

        if (winningNumber.lottoNumbers().contains(LottoNumber.lottoNumber(bonusNumber.lottoNumber()))) {
            throw new IllegalArgumentException("당첨 번호에 보너스 번호와 중복되는 번호가 들어가 있습니다.");
        }
    }
}
