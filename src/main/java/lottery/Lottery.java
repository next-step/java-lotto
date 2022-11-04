package lottery;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lottery {

    static final int LOTTERY_NUM_COUNT = 6;

    private final List<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        validate(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public int contains(Lottery lottery) {
        return this.lotteryNumbers.stream()
                .filter(lottery::contains)
                .mapToInt(lotteryNumber -> 1)
                .sum();
    }

    public boolean contains(LotteryNumber lotteryNumber) {
        return this.lotteryNumbers.contains(lotteryNumber);
    }

    public List<LotteryNumber> lotteryNumbers() {
        return Collections.unmodifiableList(this.lotteryNumbers);
    }

    private void validate(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또는 6개 숫자로 구성되어야 합니다.");
        }
        if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
