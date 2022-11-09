package lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {

    static final int LOTTERY_NUM_COUNT = 6;

    private final Set<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = new HashSet<>(lotteryNumbers);
        validate(this.lotteryNumbers);
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
        return List.copyOf(lotteryNumbers);
    }

    private void validate(Set<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또는 6개 숫자로 구성되어야 합니다.");
        }
    }
}
