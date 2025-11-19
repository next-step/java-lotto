package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean containsInLotto(LottoNumber number) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(number.getValue());
    }

    public boolean matchBonus(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
