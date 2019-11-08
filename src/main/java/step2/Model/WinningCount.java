package step2.Model;

import step2.Data.Prize;

import java.util.Arrays;

public class WinningCount {
    public static final int MIN_MATCH_COUNT = 3;
    public static final int MAX_MATCH_COUNT = 6;

    private int[] count;

    public WinningCount(int[] count) {
        this.count = count;
    }

    public float getWinningRate() {
        float earningMoney = 0;
        for (int matchCount = MIN_MATCH_COUNT;
             matchCount <= MAX_MATCH_COUNT; matchCount++) {
            earningMoney += (Prize.getPrice(matchCount) * count[matchCount]);
        }
        return earningMoney / (totalCount() * Ticket.LOTTO_PRICE);
    }

    public int countOfMatchCount(int matchCount) {
        return count[matchCount];
    }

    private int totalCount() {
        return Arrays.stream(count).reduce(Integer::sum).orElseThrow(IllegalArgumentException::new);
    }
}
