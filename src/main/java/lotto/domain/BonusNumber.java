package lotto.domain;

import java.util.List;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean getBonusMatch(List<Integer> lotto) {
        return lotto.stream()
                .anyMatch(n -> bonusNumber==n);
    }
}
