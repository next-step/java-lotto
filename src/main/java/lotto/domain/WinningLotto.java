package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this(numbers);
        setBonusNumber(bonusNumber);
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateDuplicateBonus(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicateBonus(int number) {
        if (lotto.contains(number)) {
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
