package lottery.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Lottery {

    static final int LOTTERY_SIZE = 6;
    static final int LOTTERY_NUMBER_MIN = 1;
    static final int LOTTERY_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public Prize getPrize(List<Integer> winningNumbers, int bonusNumber) {
        long matchedNumbers = numbers.stream()
                                     .filter(winningNumbers::contains)
                                     .count();
        boolean bonusNumberMatched = numbers.contains(bonusNumber);

        return Prize.getPrize(matchedNumbers, bonusNumberMatched);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate() {
        validateRangeOfNumbers();
        validateDuplicates();
    }

    private void validateRangeOfNumbers() {
        Predicate<Integer> checkRange = n -> n >= LOTTERY_NUMBER_MIN && n <= LOTTERY_NUMBER_MAX;

        if (numbers.stream().filter(checkRange).count() != LOTTERY_SIZE ) {
            throw new InvalidLotteryException();
        }
    }

    private void validateDuplicates() {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLotteryException();
        }
    }
}


