package lottery.view;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lottery.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryResultOutputView implements OutputView<LotteryResult> {
    private final List<Integer> winPrizes = Arrays.asList(WinPrize.LOST.value(), WinPrize.LOST.value(), WinPrize.LOST.value(), WinPrize.FIFTH_PLACE.value(), WinPrize.FOURTH_PLACE.value(), WinPrize.THIRD_PLACE.value(), WinPrize.SECOND_PLACE.value(), WinPrize.FIRST_PLACE.value());
    private final List<Integer> rankToMatchNumber;

    public LotteryResultOutputView() {
        rankToMatchNumber = new ArrayList<>();
        for (int i = 0; i <= Lotteries.RANK_LENGTH; i++) {
            rankToMatchNumber.add(0);
        }
        for (int i = 0; i < Lotteries.matchNumberToRank.size(); i++) {
            rankToMatchNumber.set(Lotteries.matchNumberToRank.get(i), i);
        }
    }

    @Override
    public void print(LotteryResult output) {
        final int MIN_WIN_NUMBER = 3;
        List<Integer> winNumbers = output.winNumbers();
        int totalPrize = 0;
        for (int i = MIN_WIN_NUMBER; i < Lotteries.RANK_LENGTH; i++) {
            totalPrize += winNumbers.get(i) * winPrizes.get(i);
            System.out.printf("%s (%d원)- %d개\n", rankToDetail(i), winPrizes.get(i), winNumbers.get(i));
        }
        System.out.printf("총 수익률은 %.2f입니다", (float) totalPrize / (output.numberOfLottery() * LotteryPrice.VALUE));
    }

    private String rankToDetail(int i) {
        if (i == Lotteries.BONUS_BALL_CHANCE_NUMBER_RANK) {
            return String.format("%d개 일치, 보너스 볼 일치", Lotteries.BONUS_BALL_CHANCE_NUMBER);
        }
        return String.format("%d개 일치", rankToMatchNumber.get(i));
    }
}
