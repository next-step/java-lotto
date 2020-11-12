package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class LotteryNumber {
    public static LotteryNumber of(Integer... numbers) {
        return new LotteryNumber(new HashSet<>(Arrays.asList(numbers)));
    }

    private final Set<Integer> numbers;

    public LotteryNumber(Set<Integer> numbers) {
        this.numbers = Collections.unmodifiableSet(numbers);
        if (numbers.size() != 6) {
            throw new NotEnoughNumberException();
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
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
}
