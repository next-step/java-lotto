package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_LENGTH = 6;
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int START_INDEX = 0;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = generateAllNumbers();

        return generateSortedRandomNumbers(numbers);
    }

    private List<Integer> generateSortedRandomNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        ArrayList<Integer> randoms = cutByLotteryLength(numbers);

        Collections.sort(randoms);

        return randoms;
    }

    private ArrayList<Integer> cutByLotteryLength(List<Integer> numbers) {
        return new ArrayList<>(numbers.subList(START_INDEX, LOTTERY_LENGTH));
    }

    private List<Integer> generateAllNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int number = MINIMUM_LOTTERY_NUMBER; number <= MAXIMUM_LOTTERY_NUMBER; number++) {
            numbers.add(number);
        }

        return numbers;
    }
}
