package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static final int COUNT_OF_LOTTERY_NUMBER = 6;
    private final List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateCountOfLotteryNumbers(lotteryNumbers);
        validateHasSameNumbers(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryTicket of(Integer... numbers) {
        return new LotteryTicket(Arrays.stream(numbers)
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));
    }

    public static LotteryTicket of(String numbers) {
        return  new LotteryTicket(Arrays.stream(numbers.split(", "))
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));
    }

    private void validateCountOfLotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        if(lotteryNumbers.size() != COUNT_OF_LOTTERY_NUMBER) {
            throw new LotteryGameException(ErrorCode.INCORRECT_NUMBER_COUNT);
        }
    }

    private void validateHasSameNumbers(List<LotteryNumber> lotteryNumbers) {
        long count = lotteryNumbers.stream().distinct().count();
        if(count != COUNT_OF_LOTTERY_NUMBER) {
            throw new LotteryGameException(ErrorCode.HAS_SAME_NUMBER);
        }
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public Rank findRank(LotteryTicket compare) {
        return Rank.match(countSameNumbers(compare));
    }

    private int countSameNumbers(LotteryTicket compare) {
        return (int) compare.lotteryNumbers.stream()
                .filter(lotteryNumbers::contains)
                .count();
    }

    public boolean contain(LotteryNumber lotteryNumber) {
        return lotteryNumbers.contains(lotteryNumber);
    }
}
