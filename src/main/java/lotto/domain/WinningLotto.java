package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<String> numberStrings) {
        this.lotto = new Lotto(numberStrings);
    }

    public WinningLotto(List<String> numberStrings, Integer bonusNumber) {
        this(numberStrings);
        setBonusNumber(new LottoNumber(bonusNumber));
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateDuplicateBonus(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicateBonus(LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }

    public String compareLotto(Lotto lotto) {
        final int count = lotto.match(lotto);
        boolean isBonusNumber = lotto.contains(bonusNumber.getNumber());
        if (count != 5) {
            isBonusNumber = false;
        }
        return LottoDescription.findLottoHash(count, isBonusNumber);
    }
}
