package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private final Set<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }

        Set<LotteryNumber> targetLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (targetLotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }

        this.lotteryNumbers = new TreeSet<>(lotteryNumbers);
    }

    public LotteryTicket(int[] numbers) {
        this(Arrays.stream(numbers).mapToObj(number -> new LotteryNumber(number)).collect(Collectors.toList()));
    }

    public LotteryTicket(String[] numbers) {
        this(Arrays.stream(numbers).map(number -> new LotteryNumber(Integer.parseInt(number.trim()))).collect(Collectors.toList()));
    }

    public LotteryTicket(String winningNumbers) {
        this(winningNumbers.replace(" ", "").split(","));
    }

    public Set<LotteryNumber> getLotteryNumbers() {
        return this.lotteryNumbers;
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
