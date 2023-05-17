package lottery.view;

import lottery.domain.*;

import java.util.Arrays;
import java.util.List;

public class LotteryResultOutputView implements OutputView<LotteryResult> {
    private final List<Integer> winPrizes = Arrays.asList(WinPrize.LOST.value(), WinPrize.LOST.value(), WinPrize.LOST.value(), WinPrize.FOURTH_PLACE.value(), WinPrize.THIRD_PLACE.value(), WinPrize.SECOND_PLACE.value(), WinPrize.FIRST_PLACE.value());

    @Override
    public void print(LotteryResult output) {
        final int MIN_WIN_NUMBER = 3;
        List<Integer> winNumbers = output.winNumbers();
        int totalPrize = 0;
        for (int i = MIN_WIN_NUMBER; i <= Lottery.LENGTH; i++) {
            totalPrize += winNumbers.get(i) * winPrizes.get(i);
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, winPrizes.get(i), winNumbers.get(i));
        }
        System.out.printf("총 수익률은 %.2f입니다", (float) totalPrize / (output.numberOfLottery() * LotteryPrice.VALUE));
    }
}
