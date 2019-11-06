package step2;

import java.util.Arrays;

import static step2.LottoUtil.*;

public class WinningCount {
    private int[] count;

    public WinningCount(int[] count) {
        this.count = count;
    }

    public float getWinningRate() {
        float earningMoney = 0;
        for (int correctCount = LOTTO_PRIZE_MIN_CORRECT_NUMBER; correctCount <= LOTTO_PRIZE_MAX_CORRECT_NUMBER; correctCount++) {
            earningMoney += (Prize.getPrice(correctCount) * count[correctCount]);
        }
        return earningMoney / (totalCount() * LOTTO_PRICE);
    }

    public int getCount(int correctNumber) {
        return count[correctNumber];
    }

    private int totalCount() {
        return Arrays.stream(count).reduce(Integer::sum).orElseThrow(IllegalArgumentException::new);
    }

}
