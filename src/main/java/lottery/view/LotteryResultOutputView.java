package lottery.view;

import lottery.domain.Lotteries;
import lottery.domain.LotteryResult;

import java.util.Arrays;
import java.util.List;

public class LotteryResultOutputView implements OutputView<LotteryResult> {
    private final List<Integer> winPrizes = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    @Override
    public void print(LotteryResult output) {
        final int MIN_WIN_NUMBER = 3;
        List<Integer> winNumbers = output.winNumbers();
        int totalPrize = 0;
        for (int i = MIN_WIN_NUMBER; i <= Lotteries.LOTTERY_LENGTH; i++) {
            totalPrize += winNumbers.get(i) * winPrizes.get(i);
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, winPrizes.get(i), winNumbers.get(i));
        }
        System.out.printf("총 수익률은 %.2f입니다", (float) totalPrize / (output.numberOfLottery() * Lotteries.LOTTERY_PRICE));
    }
}
