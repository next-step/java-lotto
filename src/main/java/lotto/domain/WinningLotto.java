package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        validateBonusNumber(inputWinningLotto, inputBonusNumber);
        this.winningLotto = Lotto.of(inputWinningLotto.getLottoNumbers());
        this.bonusNumber = LottoNumber.chooseNumber(inputBonusNumber.getLottoNumber());
    }

    public WinningLotto(List<Integer> inputWinningLottoNumbers, int inputBonusNumber) {
        this(Lotto.of(inputWinningLottoNumbers), LottoNumber.chooseNumber(inputBonusNumber));
    }

    public Lotto getWinningLotto() {
        return Lotto.of(this.winningLotto.getLottoNumbers());
    }

    public RankEnum getRank(Lotto lotto) {
        int matchedCount = getWinningLotto().getMatchedCount(lotto);
        boolean hasBonus = lotto.isExistNumber(this.bonusNumber);
        return RankEnum.getRank(matchedCount, hasBonus);
    }

    private void validateBonusNumber(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
        if (inputWinningLotto.isExistNumber(inputBonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스번호는 이미 있는 번호입니다.");
        }
    }
}
