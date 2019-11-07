package lotto.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryTicket {

    private static final int LOTTERY_NUMBER_SIZE = 6;
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final int LOTTERY_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public WinningRanking getRanking(List<Integer> winningNumbers, int bonusNumber) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return WinningRanking.valueOf(matchingCount, numbers.contains(bonusNumber));
    }

    public boolean isWin(List<Integer> winningNumbers, int bonusNumber) {
        return getRanking(winningNumbers, bonusNumber) != WinningRanking.MISS;
    }

    private void validateSize(List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUMBER_SIZE) {
            String message = String.format("복권 번호는 %d개 입니다.", LOTTERY_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateRange(List<Integer> lotteryNumbers) {
        boolean outOfRange = lotteryNumbers.stream()
                .anyMatch(number -> number < LOTTERY_NUMBER_MIN || number > LOTTERY_NUMBER_MAX);
        if (outOfRange) {
            String message = String.format("복권 번호의 범위는 [%d, %d] 입니다.", LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplicate(List<Integer> lotteryNumbers) {
        boolean duplicate = lotteryNumbers.stream()
                .distinct()
                .count() != lotteryNumbers.size();
        if (duplicate) {
            throw new IllegalArgumentException("복권 번호는 중복될 수 없습니다.");
        }
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
