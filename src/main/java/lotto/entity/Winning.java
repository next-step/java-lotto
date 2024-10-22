package lotto.entity;

import java.util.Set;

public class Winning {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public Winning(Set<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(Set<Integer> numbers, int bonusNumber) {
        checkForDuplicates(numbers, bonusNumber);
    }

    private void checkForDuplicates(Set<Integer> numbers, int bonusNumber) {
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
