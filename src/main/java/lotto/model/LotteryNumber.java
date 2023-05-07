package lotto.model;

import lotto.util.NumberGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber {

    private final int number;
    private static final Map<Integer, LotteryNumber> numberCache = new HashMap<>();

    private LotteryNumber(int number) {
        this.number = number;
    }

    public static LotteryNumber of(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        return numberCache.computeIfAbsent(number, k -> new LotteryNumber(number));
    }

    public boolean isIn(WinNumbers winNumbers) {
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
