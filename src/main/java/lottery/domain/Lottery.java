package lottery.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {

    static final int LOTTERY_SIZE = 6;
    static final int LOTTERY_NUMBER_MIN = 1;
    static final int LOTTERY_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Prize getPrize(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        if (!checkRange(bonusNumber) || winningNumbers.contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }

        long matchedNumbers = numbers.stream()
                                     .filter(winningNumbers::contains)
                                     .count();
        boolean bonusNumberMatched = numbers.contains(bonusNumber);

        return Prize.getPrize(matchedNumbers, bonusNumberMatched);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateRangeOfNumbers(numbers);
        validateDuplicates(numbers);
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream().filter(this::checkRange).count() != LOTTERY_SIZE ) {
            throw new InvalidLotteryException();
        }
    }

    private boolean checkRange(int number) {
        return number >= LOTTERY_NUMBER_MIN && number <= LOTTERY_NUMBER_MAX;
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLotteryException();
        }
    }
}


