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

    public String getString() {
        return lotteryNumber.getStringForPrint();
    }

    // 테스트코드 하려고 추가된 애인데요... 이렇게 하는게 맞는 건 아닌 것 같은데
    // 어떻게 해야할까요.. 잔꾀만 늘어나는 느낌입니다 ㅠ_ㅠ
    public int countMatchNumber(Lottery winningLottery) {
        return passCountMatchNumber(lotteryNumber, winningLottery.lotteryNumber);
    }

    private int passCountMatchNumber(LotteryNumber purchasedNumbers, LotteryNumber winningNumbers) {
        return purchasedNumbers.compareNumbers(winningNumbers);
    }
}
