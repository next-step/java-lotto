package lottery.domain;

import lottery.domain.vo.LotteryNumbers;

import java.util.Objects;
import java.util.Set;

public class Lottery {
    private final LotteryNumbers lotteryNumbers;

    public Lottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public Lottery(String lotteryNumberString) {
        this(new LotteryNumbers(lotteryNumberString));
    }

    public Set<Integer> lotteryNumbers(){
        return this.lotteryNumbers.numbers();
    }

    public Long matchNumbersCount(Lottery otherLottery) {
        return lotteryNumbers.matchNumbersCount(otherLottery.lotteryNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(lotteryNumbers, lottery.lotteryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumbers);
    }
}
