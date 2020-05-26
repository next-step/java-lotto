package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final int LOTTERY_NUMBER_COUNTS = 6;
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
        if (isDuplicatedLotteryNumbers(lotteryNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NUMBER);
        }
    }

    private boolean isDuplicatedLotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        long filteredLotteryNumberCounts = lotteryNumbers.stream()
                .map(LotteryNumber::getLotteryNumber)
                .distinct()
                .count();
        if (lotteryNumbers.size() != filteredLotteryNumberCounts) {
            return true;
        }
        return false;
    }
}
