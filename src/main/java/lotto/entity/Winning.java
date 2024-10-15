package lotto.entity;

import java.util.Set;

public class Winning {

    public Winning(Set<Integer> numbers, int bonusNumber) {
        validate(numbers,bonusNumber);
    }

    private void validate(Set<Integer> numbers, int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        LottoNumberRange.validateRange(bonusNumber);
    }
}
