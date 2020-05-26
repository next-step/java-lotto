package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {

    private static final int LOTTERY_NUMBER_COUNTS = 6;
    private final List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateLotteryNumbers(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<String> getLotteryNumbers() {
        return lotteryNumbers.stream()
                .map(lotteryNumber -> String.valueOf(lotteryNumber.getLotteryNumber()))
                .collect(Collectors.toList());
    }

    private void validateLotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_COUNTS);
        }
    }

}
