package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
        validateBonusNumber();
    }

    public int correctCount(Lotto myLotto) {
        return (int) numbers.stream()
                .filter(myLotto.numbers::contains)
                .count();
    }

    public boolean matchedBonus(Lotto myLotto) {
        return myLotto.numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private void validateBonusNumber() {
        if (matchedBonus(this)) throw new IllegalArgumentException("보너스 점수에 당첨 번호를 제외한 번호만 입력해주세요.");
    }
}
