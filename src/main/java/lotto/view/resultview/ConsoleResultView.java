package lotto.view.resultview;

import lotto.Lotto;
import lotto.WinningRank;
import lotto.WinningStatistic;

import java.util.EnumSet;
import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void printBoughtLottos(List<Lotto> boughtLottos) {
        System.out.println(boughtLottos.size() + "개를 구매했습니다.");
        for (Lotto boughtLotto : boughtLottos) {
            System.out.println("boughtLotto.toString() = " + boughtLotto.toString());
        }
    }

    @Override
    public void printWinningStatistic(WinningStatistic winningStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        EnumSet<WinningRank> winningRanks = EnumSet.allOf(WinningRank.class);
        for (WinningRank winningRank : winningRanks) {
            System.out.println(winningRank.winningAmount + " - " + winningStatistic.getCountOfWinningRank(winningRank));
        }
        System.out.println("총 수익률은 " + winningStatistic.getEarningsRate() + "입니다." + " (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}