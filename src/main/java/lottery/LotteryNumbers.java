package lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LotteryNumbers {

    private static final int MINIMUM_LOTTERY_NUMBERS_SIZE = 6;

    private final Set<LotteryNumber> numbers;

    public LotteryNumbers(List<Integer> numbers) {
        Set<LotteryNumber> lotteryNumbers = toSet(numbers);

        validateLotteryNumbersSize(lotteryNumbers);

        this.numbers = lotteryNumbers;
    }

    private Set<LotteryNumber> toSet(List<Integer> numbers) {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();

        for (Integer number : numbers) {
            lotteryNumbers.add(new LotteryNumber(number));
        }

        return lotteryNumbers;
    }

    private void validateLotteryNumbersSize(Set<LotteryNumber> numbers) {
        int sizeOfNumbers = numbers.size();

        if (sizeOfNumbers != MINIMUM_LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리이어야 합니다. : " + sizeOfNumbers);
        }
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumbers that = (LotteryNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
