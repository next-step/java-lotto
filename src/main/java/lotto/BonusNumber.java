package lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException("bonusNumber must be in range 1 ~ 45");
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean match(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(num -> num == bonusNumber);
    }

    private boolean isInRange(int bonusNumber) {
        return 0 < bonusNumber && bonusNumber <= 45;
    }
}


