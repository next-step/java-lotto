package lottery.domain;

import lottery.domain.winningstrategy.WinningLotteryStrategy;
import lottery.dto.LotteryDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {

    public static final String NON_NULL = "입력값은 null 일 수 없습니다";
    public static final String INVALID_LOTTERY_NUMBERS_SIZE = "로또 숫자는 6개여야 합니다 -> ";
    public static final String DUPLICATED_LOTTERY_NUMBERS = "로또에서 중복된 숫자는 존재 할 수 없습니다";
    public static final Money PRICE = new Money(1000);
    public static final int LOTTERY_NUMBERS_SIZE = 6;

    private final Set<LotteryNumber> lotteryNumbers;

    public Lottery(final List<LotteryNumber> lotteryNumbers) {
        validateLotteryNumbers(lotteryNumbers);
        this.lotteryNumbers = new LinkedHashSet<>(lotteryNumbers);
    }

    public LotteryResult getLotteryResult(final WinningLotteryStrategy winningLotteryStrategy) {
        return winningLotteryStrategy.getScore(this);
    }

    public int getMatchesCount(final Lottery lottery) {
        return (int) lottery.lotteryNumbers
                .stream()
                .filter(this.lotteryNumbers::contains)
                .count();
    }

    public LotteryDto toDto() {
        return new LotteryDto(lotteryNumbers.stream()
                .map(LotteryNumber::toDto)
                .collect(Collectors.toList()));
    }

    private void validateLotteryNumbers(final List<LotteryNumber> lotteryNumbers) {
        requireNonNull(lotteryNumbers);
        requireValidLotteryNumbersSize(lotteryNumbers.size());
        requireNotDuplicated(lotteryNumbers);
    }

    private void requireNonNull(final List<LotteryNumber> lotteryNumbers) {
        if (Objects.isNull(lotteryNumbers)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void requireValidLotteryNumbersSize(final int lotteryNumbersSize) {
        if (lotteryNumbersSize != LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTERY_NUMBERS_SIZE + lotteryNumbersSize);
        }
    }

    private void requireNotDuplicated(final List<LotteryNumber> lotteryNumbers) {
        if (containDuplicatedLotteryNumber(lotteryNumbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTERY_NUMBERS);
        }
    }

    private boolean containDuplicatedLotteryNumber(final List<LotteryNumber> lotteryNumbers) {
        return lotteryNumbers.size() != new HashSet<>(lotteryNumbers).size();
    }
}
