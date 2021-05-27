package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumbers {

    private final List<Integer> numbers;

    public LotteryNumbers(int...numbers) {
        this.numbers = new ArrayList<>();

        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public int size() {
        return this.numbers.size();
    }
}
