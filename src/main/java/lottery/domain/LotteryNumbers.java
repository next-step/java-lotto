package lottery.domain;

import com.google.common.collect.ImmutableList;

import java.util.*;

import static lottery.domain.WinnerLottery.DEFAULT_MATCH_COUNT;
import static lottery.domain.WinnerLottery.MATCH_COUNT;

public class LotteryNumbers {

    private static final int MINIMUM_LOTTERY_NUMBERS_SIZE = 6;

    private final ImmutableList<LotteryNumber> numbers;

    public LotteryNumbers(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = toLotteryNumbers(numbers);

        validateLotteryNumbersSize(lotteryNumbers);

        this.numbers = ImmutableList.copyOf(lotteryNumbers);
    }

    private List<LotteryNumber> toLotteryNumbers(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            lotteryNumbers.add(new LotteryNumber(number));
        }

        return new ArrayList<>(lotteryNumbers);
    }

    private void validateLotteryNumbersSize(List<LotteryNumber> numbers) {
        int sizeOfNumbers = new HashSet<>(numbers).size();

        if (sizeOfNumbers != MINIMUM_LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리이어야 합니다. : " + sizeOfNumbers);
        }
    }

    public int match(LotteryNumbers input) {
        int matchCount = DEFAULT_MATCH_COUNT;

        for (LotteryNumber number : numbers) {
            matchCount = addCountIfContains(input, matchCount, number);
        }

        return matchCount;
    }

    private int addCountIfContains(LotteryNumbers input, int matchCount, LotteryNumber number) {
        if (input.contains(number)) {
            return matchCount + MATCH_COUNT;
        }

        return matchCount;
    }

    public ImmutableList<LotteryNumber> numbers() {
        return numbers;
    }

    boolean contains(LotteryNumber number) {
        return numbers.contains(number);
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumbers that = (LotteryNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
