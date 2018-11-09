package domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

}
