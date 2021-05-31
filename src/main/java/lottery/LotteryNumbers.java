package lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumbers {

    private static final int MINIMUM_LOTTERY_NUMBERS_SIZE = 6;

    private final Set<Integer> numbers;

    public LotteryNumbers(List<Integer> numbers) {
        HashSet<Integer> converted = toSet(numbers);

        validateLotteryNumbersSize(converted);

        this.numbers = converted;
    }

    private HashSet<Integer> toSet(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    private void validateLotteryNumbersSize(Set<Integer> numbers) {
        int sizeOfNumbers = numbers.size();

        if (sizeOfNumbers != MINIMUM_LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리이어야 합니다. : " + sizeOfNumbers);
        }
    }

    public int size() {
        return this.numbers.size();
    }
}
