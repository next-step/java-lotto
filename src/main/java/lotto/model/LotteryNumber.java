package lotto.model;

import lotto.util.NumberGenerator;

import java.util.List;

public class LotteryNumber {

    private final int number;

    public LotteryNumber(NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public boolean isIn(List<Integer> winNumbers) {
        return winNumbers.contains(number);
    }
}
