package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
public class Lottery {
    private LotteryNumber lotteryNumber;

    public Lottery() {
        this.lotteryNumber = new LotteryNumber();
    }

    public Lottery(List<Integer> inputNumbers) {
        this.lotteryNumber = new LotteryNumber(inputNumbers);
    }

    public Lottery(LotteryNumber inputNumbers) {
        this.lotteryNumber = inputNumbers;
    }

    public String getString() {
        return lotteryNumber.getStringForPrint();
    }

    public RANK winCheck(Lottery winningLottery) {
        return passWinCheck(lotteryNumber, winningLottery.lotteryNumber);
    }

    private RANK passWinCheck(LotteryNumber purchasedNumbers, LotteryNumber winningNumbers) {
        return purchasedNumbers.compareNumbers(winningNumbers);
    }
}
