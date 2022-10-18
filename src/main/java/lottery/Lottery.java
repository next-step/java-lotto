package lottery;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lottery {

    protected final List<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        validate(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validate(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LotteryCompany.LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또는 6개 숫자로 구성되어야 합니다.");
        }
        if (new HashSet<>(lotteryNumbers).size() != LotteryCompany.LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return Collections.unmodifiableList(this.lotteryNumbers);
    }
}
