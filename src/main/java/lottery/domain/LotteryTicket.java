package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryTicket {

    private static final int VALID_COUNT_OF_NUMBERS = 6;

    final List<LotteryNumber> numbers;

    private LotteryTicket(final List<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public static LotteryTicket from(final LotteryNumberGenerator lotteryNumberGenerator) {
        return LotteryTicket.of(lotteryNumberGenerator.generate());
    }

    public static LotteryTicket of(final List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = numbers.stream()
            .distinct()
            .map(LotteryNumber::of)
            .sorted()
            .collect(Collectors.toList());

        if (lotteryNumbers.size() != VALID_COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        return new LotteryTicket(lotteryNumbers);
    }

    public List<LotteryNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
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

    public int matchedCount(final LotteryTicket otherTicket) {
        return (int) this.numbers
            .stream()
            .filter(otherTicket.numbers::contains)
            .count();
    }
}
