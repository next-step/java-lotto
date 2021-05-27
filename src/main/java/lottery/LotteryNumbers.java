package lottery;

import java.util.List;

public class LotteryNumbers {

    private static final int MINIMUM_LOTTERY_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public LotteryNumbers(List<Integer> numbers) {
        validateLotteryNumbersSize(numbers);

        this.numbers = numbers;
    }

    private void validateLotteryNumbersSize(List<Integer> numbers) {
        int sizeOfNumbers = numbers.size();
        if (sizeOfNumbers != MINIMUM_LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리이어야 합니다. : " + sizeOfNumbers);
        }
    }

    public int size() {
        return this.numbers.size();
    }
}
