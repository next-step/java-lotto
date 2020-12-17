package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private final Set<LotteryNumber> lotteryNumbers;

    private LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }

        Set<LotteryNumber> targetLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (targetLotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }

        this.lotteryNumbers = new TreeSet<>(lotteryNumbers);
    }

    public static LotteryTicket of(String numbers) {
        List<LotteryNumber> lotteryNumbers = Arrays.stream(numbers.trim().split(","))
                .map(Integer::parseInt)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        return new LotteryTicket(lotteryNumbers);
    }

    public static LotteryTicket of(List<LotteryNumber> numbers) {
        return new LotteryTicket(numbers);
    }

    public Set<LotteryNumber> getLotteryNumbers() {
        return this.lotteryNumbers;
    }

    public boolean contains(LotteryNumber lotteryNumber) {
        return this.lotteryNumbers.contains(lotteryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(lotteryNumbers, that.lotteryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumbers);
    }
}
