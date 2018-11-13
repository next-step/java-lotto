package domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final LottoNumber bonus;

    public WinningNumber(List<Integer> numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public boolean isContain(LottoNumber number) {
        return numbers.contains(number.getNumber());
    }

    public boolean isBonusMatched(LottoNumber number) {
        return number.equals(bonus);
    }
}
