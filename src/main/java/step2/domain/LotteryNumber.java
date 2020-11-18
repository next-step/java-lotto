package step2.domain;

import step2.utils.Sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static step2.domain.Playslip.SELECTION_COUNT;

public class LotteryNumber {
    public static LotteryNumber of(Integer... numbers) {
        return new LotteryNumber(Sets.of(numbers));
    }

    private final Set<Integer> numbers;

    public LotteryNumber(Set<Integer> numbers) {
        if (numbers.size() != SELECTION_COUNT) {
            throw new NotEnoughNumberException();
        }
        this.numbers = Collections.unmodifiableSet(numbers);
    }

    public int getMatched(LotteryNumber other) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.numbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotteryNumber that = (LotteryNumber) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    /**
     * Visible for tests
     */
    LotteryNumber copy() {
        return new LotteryNumber(numbers);
    }
}
