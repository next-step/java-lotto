package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int START_INDEX = 0;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = generateAllNumbers();

        return generateSortedRandomNumbers(numbers);
    }

    private List<Integer> generateSortedRandomNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
        Collections.sort(numbers);

        return new ArrayList<>(numbers.subList(START_INDEX, LOTTO_LENGTH));
    }

    private List<Integer> generateAllNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int number = MINIMUM_LOTTERY_NUMBER; number <= MAXIMUM_LOTTERY_NUMBER; number++) {
            numbers.add(number);
        }

        return numbers;
    }
}
