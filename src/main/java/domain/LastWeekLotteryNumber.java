package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LastWeekLotteryNumber {
    private static final String LOTTERY_NUMBER_LACK_ERROR_MESSAGE = "error : 로또 번호는 중복되지 않는 번호 6개 입니다.";
    private static final String NULL_ERROR_MESSAGE = "error : Null 값은 입력할수 없습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백 은 입력할수 없습니다.";
    private static final int LOTTERY_NUMBER_SIX = 6;
    private static final String COMMA = ",";
    private final Set<Number> lastWeekLotteryNumber;

    public LastWeekLotteryNumber(String lastWeekLotteryNumber) {
        checkTextNull(lastWeekLotteryNumber);
        checkTextEmpty(lastWeekLotteryNumber);
        this.lastWeekLotteryNumber = Collections.unmodifiableSet(lastWeekLottery(lastWeekLotteryNumber));
    }

    private void checkTextNull(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private void checkTextEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public Set<Number> lastWeekLottery(String lastWeekLotteryNumber) {
        Set<Integer> numbers = removeOverlap(lastWeekLotteryNumber);

        validLastWeekLotteryNumber(numbers.size());

        return of(numbers);
    }

    public Set<Integer> removeOverlap(String lastWeekLotteryNumber) {
        return Arrays.stream(lastWeekLotteryNumber.split(COMMA))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toSet());
    }

    private void validLastWeekLotteryNumber(int count) {
        if (count < LOTTERY_NUMBER_SIX) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_LACK_ERROR_MESSAGE);
        }
    }

    public int lotteryMatch(int number) {
        return (int) lastWeekLotteryNumber.stream()
                .filter(i -> i.value() == number)
                .count();
    }

    public Set<Number> of(Set<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toSet());
    }

    public int size() {
        return lastWeekLotteryNumber.size();
    }
}
