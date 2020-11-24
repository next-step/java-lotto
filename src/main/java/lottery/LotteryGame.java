package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGame {
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

    private int[] getLotteryNumbers() {
        List<Integer> lotteryAllNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
        Collections.shuffle(lotteryAllNumbers);
        return convertIntegerToInt(lotteryAllNumbers.subList(0, 6));
    }

    private int[] convertIntegerToInt(List<Integer> numbers) {
        int[] lotteryNumbers = new int[6];
        int i = 0;
        for(Integer integer : numbers) {
            lotteryNumbers[i] = integer.intValue();
            i++;
        }
        return lotteryNumbers;
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
