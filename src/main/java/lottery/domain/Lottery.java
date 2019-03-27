package lottery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Lottery {
    private LotteryNumber lotteryNumber;

    public Lottery() {
        this.lotteryNumber = new LotteryNumber();
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
