package lotto.domain;

public class WinningLotto {

    private static final String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private Lotto winningNumber;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.getLottoNumbers().contains(bonusNumber.getLottoNumber())) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
