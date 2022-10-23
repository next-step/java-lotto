package lottery;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lottery {

    static final int LOTTERY_NUM_COUNT = 6;
    protected static final String LOTTERY_NUM_DUPLICATED_ERR_MSG = "로또 번호는 중복될 수 없습니다.";
    public static final String LOTTERY_NUM_COUNT_ERR_MSG = "로또는 6개 숫자로 구성되어야 합니다.";

    protected final List<LotteryNumber> lotteryNumbers;

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        validate(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validate(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException(LOTTERY_NUM_COUNT_ERR_MSG);
        }
        if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUM_COUNT) {
            throw new IllegalArgumentException(LOTTERY_NUM_DUPLICATED_ERR_MSG);
        }
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return Collections.unmodifiableList(this.lotteryNumbers);
    }
}
