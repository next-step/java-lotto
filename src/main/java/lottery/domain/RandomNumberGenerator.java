package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int LOTTERY_LENGTH = 6;
    public static final int START_INDEX = 0;
    private static final List<Integer> LOTTERY_NUMBERS = generateAllLotteryNumbers();

    @Override
    public List<Integer> generate() {
        return generateSortedRandomNumbers(LOTTERY_NUMBERS);
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

    private static List<Integer> generateAllLotteryNumbers() {
        List<Integer> lotteryNumbers = new ArrayList<>();

        for (int number = LotteryNumber.MINIMUM; number <= LotteryNumber.MAXIMUM; number++) {
            lotteryNumbers.add(number);
        }

        return lotteryNumbers;
    }
}
