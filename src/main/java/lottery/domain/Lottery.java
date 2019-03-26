package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class Lottery {
    private LotteryNumber lotteryNumber;

    public Lottery() {
        this.lotteryNumber = new LotteryNumber();
    }

    public Lottery(List<Integer> inputNumbers) {
        this.lotteryNumber = new LotteryNumber(inputNumbers);
    }

    public Lottery(List<Integer> inputNumbers, int bonusNumber) {
        this.lotteryNumber = new LotteryNumber(inputNumbers, bonusNumber);
    }

    public String getString() {
        return lotteryNumber.getStringForPrint();
    }

    public int winCheck(Lottery winningLottery) {
        return passWinCheck(lotteryNumber, winningLottery.lotteryNumber);
    }

    private int passWinCheck(LotteryNumber purchasedNumbers, LotteryNumber winningNumbers) {
        return purchasedNumbers.compareNumbers(winningNumbers);
    }
}
