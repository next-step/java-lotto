package step2.Model;

import step2.Data.Prize;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WinningCount {
    public static final int MIN_MATCH_COUNT = 3;
    public static final int MAX_MATCH_COUNT = 6;

    private int[] count;

    public WinningCount(int[] count) {
        this.count = count;
    }

    public int countOfMatchCount(int matchCount) {
        return count[matchCount];
    }

    public float calculateWinningRate() {
        return calculateTotalEarningMoney() / calculateTicketPrice();
    }

    private float calculateTotalEarningMoney() {
        return IntStream.rangeClosed(MIN_MATCH_COUNT, MAX_MATCH_COUNT)
                .map(i -> Prize.calculateEarningMoney(i, count[i]))
                .sum();
    }

    private int calculateTicketPrice() {
        int totalCount = Arrays.stream(count)
                .reduce(Integer::sum)
                .orElseThrow(IllegalArgumentException::new);
        return totalCount * Ticket.LOTTO_PRICE;
    }
}
