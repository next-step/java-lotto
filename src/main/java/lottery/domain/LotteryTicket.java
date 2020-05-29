package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicket {

    public static final int LOTTERY_NUMBER_COUNTS = 6;
    private static final List<Integer> LOTTERY_NUMBERS_LIST = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());
    private final List<LotteryNumber> lotteryNumbers;

    private LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateLotteryNumbers(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryTicket publishAutomatic() {
        Collections.shuffle(LOTTERY_NUMBERS_LIST);
        List<Integer> pickedLotteryNumbers = LOTTERY_NUMBERS_LIST.subList(0, 6);
        Collections.sort(pickedLotteryNumbers);
        return new LotteryTicket(
                pickedLotteryNumbers.stream()
                        .map(number -> LotteryNumber.from(number))
                        .collect(Collectors.toList()));
    }

    public static LotteryTicket from(List<LotteryNumber> lotteryNumbers) {
        return new LotteryTicket(lotteryNumbers);
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers.stream()
                .map(LotteryNumber::getLotteryNumber)
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
        return lotteryNumbers.size() != filteredLotteryNumberCounts;
    }
}
