package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicket {
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int FROM_INDEX = 0;
    private static final int END_INCLUSIVE = 45;
    private static final int START_INCLUSIVE = 1;
    private static List<LotteryNumber> lotteryAllNumbers = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed()
            .map(LotteryNumber::of)
            .collect(Collectors.toList());

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

    
    public static LotteryTicket auto() {
        Collections.shuffle(lotteryAllNumbers);
        return new LotteryTicket(lotteryAllNumbers.subList(FROM_INDEX, NUMBER_OF_LOTTERY_NUMBERS));
    }

    public static LotteryTicket manual(String numbers) {
        Collections.sort(lotteryAllNumbers);
        return new LotteryTicket(Arrays.stream(numbers
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::parseInt)
                .map(index -> lotteryAllNumbers.get(index - 1))
                .collect(Collectors.toList()));
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

    @Override
    public String toString() {
        String numbers = "";
        Iterator iter = this.lotteryNumbers.iterator();
        while(iter.hasNext()) {
            numbers += (iter.next()+ ", ");
        }
        return "LotteryTicket: " + numbers;
    }
}
