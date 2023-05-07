package lotto.model;

import lotto.util.NumberGenerator;

import java.util.List;
import java.util.Objects;

public class LotteryNumber {

    private final int number;

    public LotteryNumber(NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
    }

    public boolean isIn(List<Integer> winNumbers) {
        return winNumbers.contains(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
