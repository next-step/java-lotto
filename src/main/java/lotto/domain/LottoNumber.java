package lotto.domain;

import java.util.List;

public class LottoNumber {
    int number;

    public LottoNumber(String value) {
        int bonusNumber = Parser.parseNumberFormat(value);
        if (numberRangeCheck(bonusNumber)) {
            throw new IllegalArgumentException("숫자 범위를 벗어납니다. 숫자범위 : 1~45");
        }
        this.number = bonusNumber;
    }
    public boolean belongs(List<Integer> values) {
        return values.contains(number);
    }

    public int getNumber() {
        return this.number;
    }

    private boolean numberRangeCheck(int value) {
        return value < Lotto.START_NUMBER || value > Lotto.END_NUMBER;
    }
}
