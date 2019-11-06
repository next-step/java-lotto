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

    public WinningRanking getRanking(List<Integer> winningNumbers) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return WinningRanking.getByMatchingCount(matchingCount);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTERY_NUMBER_SIZE) {
            String message = String.format("당첨 번호는 %d개 입니다.", LOTTERY_NUMBER_SIZE);
            throw new RuntimeException(message);
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        boolean outOfRange = winningNumbers.stream()
                .anyMatch(number -> number < LOTTERY_NUMBER_MIN || number > LOTTERY_NUMBER_MAX);
        if (outOfRange) {
            String message = String.format("당첨 번호의 범위는 [%d, %d] 입니다.", LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX);
            throw new RuntimeException(message);
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        boolean duplicate = winningNumbers.stream()
                .distinct()
                .count() != winningNumbers.size();
        if (duplicate) {
            throw new RuntimeException("당첨 번호는 중복될 수 없습니다.");
        }
    }
}
