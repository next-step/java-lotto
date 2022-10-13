package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int LOTTERY_NUM_COUNT = 6;

    private static final List<LotteryNumber> LOTTERY_NUMBER_CANDIDATES = IntStream
            .range(1, LotteryNumber.LOTTERY_NUM_MAX + 1)
            .mapToObj(LotteryNumber::new)
            .collect(Collectors.toList());

    private final List<LotteryNumber> lotteryNumbers;

    public Lottery() {
        this(generateLotteryNumbers());
    }

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        validate(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public static Lottery getInstanceByInt(List<Integer> lotteryNumbers) {
        return new Lottery(mapIntegersToLotteryNumbers(lotteryNumbers));
    }

    private static List<LotteryNumber> mapIntegersToLotteryNumbers(List<Integer> lotteryNumbers) {
        return lotteryNumbers.stream().map(LotteryNumber::new).collect(Collectors.toList());
    }

    private void validate(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또는 6개 숫자로 구성되어야 합니다.");
        }
        if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public int countEqualNumbers(Lottery lottery) {
        return lottery.lotteryNumbers.stream()
                .filter(this.lotteryNumbers::contains)
                .mapToInt(lotteryNumber -> 1)
                .sum();
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return Collections.unmodifiableList(this.lotteryNumbers);
    }

    private static List<LotteryNumber> generateLotteryNumbers() {
        Collections.shuffle(LOTTERY_NUMBER_CANDIDATES);
        List<LotteryNumber> lotteryNumbers = LOTTERY_NUMBER_CANDIDATES.subList(0, LOTTERY_NUM_COUNT);
        Collections.sort(lotteryNumbers);

        return new ArrayList<>(lotteryNumbers);
    }
}
