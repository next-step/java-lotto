package step2.Model;

import step2.Data.Prize;

import java.util.Arrays;

import static step2.Util.LottoUtil.*;

public class WinningCount {
    private int[] count;

    public WinningCount(int[] count) {
        this.count = count;
    }

    public float getWinningRate() {
        float earningMoney = 0;
        for (int matchCount = LOTTO_PRIZE_MIN_MATCH_NUMBER;
             matchCount <= LOTTO_PRIZE_MAX_MATCH_NUMBER; matchCount++) {
            earningMoney += (Prize.getPrice(matchCount) * count[matchCount]);
        }
        return earningMoney / (totalCount() * LOTTO_PRICE);
    }

    public int getCount(int matchCount) {
        return count[matchCount];
    }

    private int totalCount() {
        return Arrays.stream(count).reduce(Integer::sum).orElseThrow(IllegalArgumentException::new);
    }
}
