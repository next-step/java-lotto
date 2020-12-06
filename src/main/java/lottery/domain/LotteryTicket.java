package lottery.domain;

import java.util.*;

public class LotteryTicket {
    public static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
//    private final List<LotteryNumber> lotteryNumbers;
    private final SortedSet<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }

        Set<LotteryNumber> targetLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (targetLotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }

        this.lotteryNumbers = new TreeSet<>();
//        this.lotteryNumbers = new ArrayList<>();
        for (LotteryNumber number : lotteryNumbers) {
            this.lotteryNumbers.add(new LotteryNumber(number.getNumber()));
        }

//        Collections.sort(this.lotteryNumbers);
    }

    public LotteryTicket(int[] numbers) {
//        this.lotteryNumbers = new ArrayList<>();
        this.lotteryNumbers = new TreeSet<>();
        LotteryNumber lotteryNumber;
        for(int number : numbers) {
            lotteryNumber = new LotteryNumber(number);
            this.lotteryNumbers.add(lotteryNumber);
        }
        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }
//        Collections.sort(this.lotteryNumbers);
    }

    public LotteryTicket(String[] numbers) {
//        lotteryNumbers = new ArrayList<>();
        this.lotteryNumbers = new TreeSet<>();
        LotteryNumber lotteryNumber;
        for(String number : numbers) {
            lotteryNumber = new LotteryNumber(Integer.parseInt(number.trim()));
            lotteryNumbers.add(lotteryNumber);
        }

        if (lotteryNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("중복없는 6개의 숫자가 입력되어야 합니다.");
        }
//        Collections.sort(this.lotteryNumbers);
    }

    public LotteryTicket(String winningNumbers) {
        this(winningNumbers.replace(" ", "").split(","));
    }

//    public List<LotteryNumber> getLotteryNumbers() {
//        return this.lotteryNumbers;
//    }
    public SortedSet<LotteryNumber> getLotteryNumbers() {
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
