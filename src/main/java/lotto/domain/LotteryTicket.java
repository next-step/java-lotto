package lotto.domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryTicket {

    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final List<LotteryNumber> numbers;

    public LotteryTicket(List<LotteryNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public static LotteryTicket from(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = numbers.stream()
                .map(LotteryNumber::of)
                .collect(toList());
        return new LotteryTicket(lotteryNumbers);
    }

    public List<LotteryNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isWin(LotteryTicket winningNumbers, LotteryNumber bonusNumber) {
        return getRanking(winningNumbers, bonusNumber) != WinningRanking.MISS;
    }

    public WinningRanking getRanking(LotteryTicket winningNumbers, LotteryNumber bonusNumber) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return WinningRanking.valueOf(matchingCount, numbers.contains(bonusNumber));
    }

    private void validateSize(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUMBER_SIZE) {
            String message = String.format("복권 번호는 %d개 입니다.", LOTTERY_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplicate(List<LotteryNumber> lotteryNumbers) {
        boolean duplicate = lotteryNumbers.stream()
                .distinct()
                .count() != lotteryNumbers.size();
        if (duplicate) {
            throw new IllegalArgumentException("복권 번호는 중복될 수 없습니다.");
        }
    }

    public boolean contains(LotteryNumber lotteryNumber) {
        return numbers.contains(lotteryNumber);
    }
}
