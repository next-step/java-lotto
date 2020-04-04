package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        validateBonusNumber(inputWinningLotto, inputBonusNumber);
        this.winningLotto = inputWinningLotto;
        this.bonusNumber = inputBonusNumber;
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

    private void validateBonusNumber(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        if (inputWinningLotto.isExistNumber(inputBonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스번호는 이미 있는 번호입니다.");
        }
    }
}
