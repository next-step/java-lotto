package domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public boolean isBonusMatched(int number) {
        return number == bonus;
    }
}
