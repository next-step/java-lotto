package lotto.domain;

import java.util.List;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String value) {
        int bonusNumber = Parser.parseNumberFormat(value);
        if (numberRangeCheck(bonusNumber)) {
            throw new IllegalArgumentException("숫자 범위를 벗어납니다. 숫자범위 : 1~45");
        }
        this.bonusNumber = bonusNumber;
    }
    public boolean belongs(List<Integer> values) {
        return values.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private boolean numberRangeCheck(int value) {
        return value < Lotto.START_NUMBER || value > Lotto.END_NUMBER;
    }
}
