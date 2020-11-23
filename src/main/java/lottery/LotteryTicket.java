package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LotteryTicket {
    private final List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public LotteryTicket(int[] numbers) {
        lotteryNumbers = new ArrayList<>();
        LotteryNumber lotteryNumber;
        for(int number : numbers) {
            lotteryNumber = new LotteryNumber(number);
            lotteryNumbers.add(lotteryNumber);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(lotteryNumbers, that.lotteryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumbers);
    }
}
