package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryTicket {

    private static final int VALID_COUNT_OF_NUMBERS = 6;

    final List<LotteryNumber> numbers;

    private LotteryTicket(final List<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public static LotteryTicket createWithRandomNumbers() {
        final List<LotteryNumber> allNumbers = IntStream.rangeClosed(LotteryNumber.MINIMUM_LOTTERY_NUMBER, LotteryNumber.MAXIMUM_LOTTERY_NUMBER)
            .mapToObj(LotteryNumber::of)
            .collect(Collectors.toList());
        Collections.shuffle(allNumbers);

        final List<LotteryNumber> lotteryNumbers = allNumbers.stream()
            .limit(VALID_COUNT_OF_NUMBERS)
            .sorted()
            .collect(Collectors.toList());

        return new LotteryTicket(lotteryNumbers);
    }

    public static LotteryTicket of(int number1, int number2, int number3, int number4, int number5, int number6) {
        List<LotteryNumber> lotteryNumbers = Stream.of(number1, number2, number3, number4, number5, number6)
            .distinct()
            .map(LotteryNumber::of)
            .sorted()
            .collect(Collectors.toList());

        if (lotteryNumbers.size() != VALID_COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        return new LotteryTicket(lotteryNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
