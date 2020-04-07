package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        validateBonusNumber(inputWinningLotto, inputBonusNumber);
        this.winningLotto = Lotto.manual(inputWinningLotto.getLottoNumbers());
        this.bonusNumber = LottoNumber.chooseNumber(inputBonusNumber.getLottoNumber());
    }

    public WinningLotto(Lotto inputWinningLotto, int inputBonusNumber) {
        this(inputWinningLotto, LottoNumber.chooseNumber(inputBonusNumber));
    }

    public WinningLotto(List<Integer> inputWinningLottoNumbers, LottoNumber inputBonusNumber) {
        this(Lotto.manual(inputWinningLottoNumbers), inputBonusNumber);
    }

    public WinningLotto(List<Integer> inputWinningLottoNumbers, int inputBonusNumber) {
        this(Lotto.manual(inputWinningLottoNumbers), LottoNumber.chooseNumber(inputBonusNumber));
    }

    public Lotto getWinningLotto() {
        return Lotto.manual(this.winningLotto.getLottoNumbers());
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
