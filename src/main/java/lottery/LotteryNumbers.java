package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumbers {

    private final List<Integer> numbers;

    public LotteryNumbers(int...numbers) {
        this.numbers = new ArrayList<>();

        validateLotteryNumbersSize(numbers);

        fillNumbers(numbers);
    }

    private void validateLotteryNumbersSize(int[] numbers) {
        int sizeOfNumbers = numbers.length;
        if (sizeOfNumbers != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리이어야 합니다. : " + sizeOfNumbers);
        }
    }

    private void fillNumbers(int[] numbers) {
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public int size() {
        return this.numbers.size();
    }
}
