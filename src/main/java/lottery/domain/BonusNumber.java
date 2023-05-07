package lottery.domain;


import java.util.Set;

public class BonusNumber {

    private final LotteryNumber value;

    public BonusNumber(int lotteryNumber) {
        this(new LotteryNumber(lotteryNumber));
    }

    public BonusNumber(LotteryNumber lotteryNumber) {
        this.value = lotteryNumber;
    }

    public boolean containsNumber(Set<LotteryNumber> lotteryNumbers) {
        return value.containsNumber(lotteryNumbers);
    }

}
