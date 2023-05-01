package step2.domain;

import java.util.List;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public Integer get() {
        return this.number;
    }

    public boolean isContained(List<Integer> numbers) {
        return numbers.contains(this.number);
    }
}
