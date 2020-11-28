package lottery.domain;

import java.util.*;

public class LotteryTicket {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private final List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }

        Set<LotteryNumber> targetLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (targetLotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }

        this.lotteryNumbers = lotteryNumbers;
        Collections.sort(this.lotteryNumbers);
    }

    public LotteryTicket(int[] numbers) {
        lotteryNumbers = new ArrayList<>();
        LotteryNumber lotteryNumber;
        for(int number : numbers) {
            lotteryNumber = new LotteryNumber(number);
            lotteryNumbers.add(lotteryNumber);
        }
        Collections.sort(this.lotteryNumbers);
    }

    public LotteryTicket(String[] numbers) {
        lotteryNumbers = new ArrayList<>();
        LotteryNumber lotteryNumber;
        for(String number : numbers) {
            lotteryNumber = new LotteryNumber(Integer.parseInt(number.trim()));
            lotteryNumbers.add(lotteryNumber);
        }
        Collections.sort(this.lotteryNumbers);
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return this.lotteryNumbers;
    }

    public int getCountsMatched(LotteryTicket winningLotteryTicket) {
        int matchCount = 0;
        for(LotteryNumber number : this.getLotteryNumbers()) {
            matchCount += number.isContainNumber(winningLotteryTicket);
        }
        return matchCount;
    }

    public int matchLotteryTicket(String winningNumbers) {
        String[] numbers = winningNumbers.replace(" ", "").split(",");
        LotteryTicket winningLotteryTicket = new LotteryTicket(numbers);

        return this.getCountsMatched(winningLotteryTicket);
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
