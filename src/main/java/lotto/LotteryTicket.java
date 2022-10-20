package lotto;

import java.util.List;

public class LotteryTicket {
    public static final int COUNT_OF_LOTTERY_NUMBER = 6;
    private List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateCountOfLotteryNumbers(lotteryNumbers);
        validateHasSameNumbers(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validateCountOfLotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        if(lotteryNumbers.size() != COUNT_OF_LOTTERY_NUMBER) {
            throw new LotteryGameException(ErrorCode.INCORRECT_NUMBER_COUNT);
        }
    }

    private void validateHasSameNumbers(List<LotteryNumber> lotteryNumbers) {
        long count = lotteryNumbers.stream().distinct().count();
        if(count != COUNT_OF_LOTTERY_NUMBER) {
            throw new LotteryGameException(ErrorCode.HAS_SAME_NUMBER);
        }
    }
}
