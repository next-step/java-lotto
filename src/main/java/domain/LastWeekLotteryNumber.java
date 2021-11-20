package domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class LastWeekLotteryNumber {
    private final Set<LotteryNumber> lastWeekLotteryNumber;

    private static final String LOTTERY_NUMBER_LACK_ERROR_MESSAGE = "error : 로또 번호는 중복되지 않는 번호 6개 입니다.";
    private static final int LOTTERY_NUMBER_SIX = 6;

    public LastWeekLotteryNumber(Set<Integer> numbers) {
        this.lastWeekLotteryNumber = Collections.unmodifiableSet(lastWeekLottery(numbers));
    }

    public Set<LotteryNumber> lastWeekLottery(Set<Integer> numbers) {
        validLastWeekLotteryNumber(numbers.size());

        return of(numbers);
    }

    private void validLastWeekLotteryNumber(int count) {
        if (count < LOTTERY_NUMBER_SIX) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_LACK_ERROR_MESSAGE);
        }
    }

    public Set<LotteryNumber> of(Set<Integer> numbers) {
        return numbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toSet());
    }

    public int matchNumber(int number) {
        return (int) lastWeekLotteryNumber.stream()
                .filter(i -> i.value() == number)
                .count();
    }

    public int size() {
        return lastWeekLotteryNumber.size();
    }
}
