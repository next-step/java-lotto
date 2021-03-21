package lottery.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumbers {

    static final int LOTTERY_SIZE = 6;

    private final List<LotteryNumber> numbers;

    public LotteryNumbers(List<LotteryNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(LotteryNumber lotteryNumber) {
        return numbers.contains(lotteryNumber);
    }

    public long countMatchedNumbers(LotteryNumbers lotteryNumbers) {
        return numbers.stream()
                      .filter(lotteryNumbers.numbers::contains)
                      .count();
    }

    private void validate(List<LotteryNumber> numbers) {
        validateLotteryNumberSize(numbers);
        validateDuplicates(numbers);
    }

    private void validateLotteryNumberSize(List<LotteryNumber> numbers) {
        if (numbers.size() != LOTTERY_SIZE) {
            throw new InvalidLotteryException();
        }
    }

    private void validateDuplicates(List<LotteryNumber> numbers) {
        Set<LotteryNumber> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLotteryException();
        }
    }
}
