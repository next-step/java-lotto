package lotto.entity;

import java.util.Set;

public class Winning {

    public Winning(Set<Integer> numbers, int bonusNumber) {
        validate(numbers,bonusNumber);
    }

    private void validate(Set<Integer> numbers, int bonusNumber) {
        validateRange(bonusNumber);
        checkForDuplicates(numbers,bonusNumber);
    }

    private void checkForDuplicates(Set<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨번호와 보너스 번호 중복입니다");
        }
    }

    private void validateRange(int bonusNumber) {
        LottoNumberRange.validateRange(bonusNumber);
    }
}
