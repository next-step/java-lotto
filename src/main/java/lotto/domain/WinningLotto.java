package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);

        validateRange(bonusNumber);
        validateDuplicateBonus(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private static void validateDuplicateBonus(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }
}
