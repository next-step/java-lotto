package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        this.winningLotto = inputWinningLotto;
        this.bonusNumber = inputBonusNumber;
        validateBonusNumber(winningLotto, bonusNumber);
    }

    public WinningLotto(Lotto inputWinningLotto, int inputBonusNumber) {
        this(inputWinningLotto, LottoNumber.newChooseNumber(inputBonusNumber));
    }

    public WinningLotto(String inputWinningLottoNumbers, LottoNumber inputBonusNumber) {
        this(Lotto.newManual(inputWinningLottoNumbers), inputBonusNumber);
    }

    public WinningLotto(String inputWinningLottoNumbers, int inputBonusNumber) {
        this(Lotto.newManual(inputWinningLottoNumbers), LottoNumber.newChooseNumber(inputBonusNumber));
    }

    public Lotto getWinningLotto() {
        return Lotto.newManual(this.winningLotto.getLottoNumbers());
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLottoNumbers, LottoNumber bonusNumber) {
        if (winningLottoNumbers.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스번호는 이미 있는 번호입니다.");
        }
    }
}
