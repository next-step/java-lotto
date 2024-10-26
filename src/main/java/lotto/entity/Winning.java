package lotto.entity;

import java.util.Set;

public class Winning {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public Winning(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningNumbers = Lotto.valueOf(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        checkForDuplicates(numbers, bonusNumber);
    }

    private void checkForDuplicates(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호 중복입니다");
        }
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(winningNumbers);
    }

    public boolean isCollectBonus(Lotto lotto) {
        return lotto.isCollectBonusNumber(this.bonusNumber);
    }
}
