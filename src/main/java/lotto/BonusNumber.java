package lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean match(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(num -> num == bonusNumber);
    }
}


