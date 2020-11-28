package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGame {
    public static final int END_INCLUSIVE = 45;
    public static final int START_INCLUSIVE = 1;
    public static final int FROM_INDEX = 0;

    private final int price;
    private final int pickCounts;

    public LotteryGame(int price, int pickCounts) {
        this.price = price;
        this.pickCounts = pickCounts;
    }

    public int buyNumberOfLotteryTickets(int cost) {
        return cost / this.price;
    }

    public List<LotteryTicket> buyLotteryTickets(int numberOfTickets) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        LotteryTicket lotteryTicket;
        for(int i = 0; i < numberOfTickets; i++) {
            lotteryTicket = new LotteryTicket(getLotteryNumbers());
            lotteryTickets.add(lotteryTicket);
        }
        return lotteryTickets;
    }

    private List<LotteryNumber> getLotteryNumbers() {
        List<Integer> lotteryAllNumbers = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lotteryAllNumbers);
        return createLotteryNumbersByNumbers(lotteryAllNumbers.subList(FROM_INDEX, pickCounts));
    }

    //TODO : LotteryTicket의 생성자로 처리하면 해당 로직은 여기에 있을 필요는 없어보임 --> 생성자에서 List<> 이렇게 되어서 문제가 발생함
    private List<LotteryNumber> createLotteryNumbersByNumbers(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        LotteryNumber lotteryNumber;
        for(Integer integer : numbers) {
            lotteryNumber = new LotteryNumber(integer.intValue());
            lotteryNumbers.add(lotteryNumber);
        }
        return lotteryNumbers;
    }

    public LotteryResult matchLotteryTickets(String winningNumbers, List<LotteryTicket> lotteryTickets) {
        String[] numbers = winningNumbers.replace(" ", "").split(",");
        LotteryTicket winningLotteryTicket = new LotteryTicket(numbers);

        LotteryResult lotteryResult = new LotteryResult();
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            lotteryResult.update(lotteryTicket.getCountsMatched(winningLotteryTicket), 1);
        }
        return lotteryResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryGame that = (LotteryGame) o;
        return price == that.price &&
                pickCounts == that.pickCounts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, pickCounts);
    }
}
