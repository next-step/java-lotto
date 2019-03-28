package domain;

import util.WinType;

public class WinningLotto {
    private Numbers numbers;
    private Integer bonus;

    public WinningLotto(Numbers numbers, Integer bonus) {
        assert !numbers.hasNumber(bonus);

        this.numbers = numbers;
        this.bonus = bonus;
    }

    WinType figure(Numbers numbers) {
        long count = this.numbers.count(numbers);
        WinType type = WinType.findByCount(count);

        if (type.isThird() && numbers.hasNumber(bonus)) {
            return WinType.SECOND;
        }
        return type;
    }
}
