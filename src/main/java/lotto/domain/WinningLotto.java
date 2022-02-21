package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private LottoNumber bonusLottoNumber;

    public WinningLotto(List<String> numberStrings) {
        this.lotto = new Lotto(numberStrings);
    }

    public WinningLotto(List<String> numberStrings, Integer bonusNumber) {
        this(numberStrings);
        setBonusLottoNumber(new LottoNumber(bonusNumber));
    }

    public void setBonusLottoNumber(LottoNumber bonusLottoNumber) {
        this.bonusLottoNumber = bonusLottoNumber;
        validateDuplicateBonus(bonusLottoNumber);
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }

    private void validateDuplicateBonus(LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }

    public String compareLotto(Lotto myLotto) {
        final int count = myLotto.match(lotto);
        final boolean isBonusNumber = myLotto.matchBonusNumber(count, bonusLottoNumber);
        return LottoDescription.findLottoHash(count, isBonusNumber);
    }
}
