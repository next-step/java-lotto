package domain;

import util.WinType;

public class WinningLotto {
    private Numbers numbers;
    private Integer bonus;

    public WinningLotto(Numbers numbers, Integer bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    WinType figure(Numbers numbers) {
        long count = this.numbers.count(numbers);
        if (count == WinType.THIRD.getCount() && numbers.hasNumber(bonus)) {
            return WinType.SECOND;
        }
        return WinType.findByCount(count);
    }
}
