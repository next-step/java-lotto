package lotto.vo;

import java.util.List;

public class LotteryNumbers {
    private List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public int lotteryNumbersCount() {
        return lotteryNumbers.size();
    }

    @Override
    public String toString() {
        StringBuilder lotteryNumberBuilder = new StringBuilder();
        for(LotteryNumber lotteryNumber : lotteryNumbers){
            lotteryNumberBuilder.append(lotteryNumber);
        }
        return lotteryNumberBuilder.toString();
    }
}
