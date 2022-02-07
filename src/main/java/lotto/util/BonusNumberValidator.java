package lotto.util;

import java.util.List;
import lotto.domain.lotto.number.Number;

public class BonusNumberValidator extends NumberValidator{

    private BonusNumberValidator() {
    }

    public static Integer validateDuplicateBonus(Integer number, List<Number> numbers) {
        if (numbers.contains(new Number(number))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
        return number;
    }
}
