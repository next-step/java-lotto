package lotto.ui;

import lotto.business.PlayLotto;
import lotto.objects.*;

import java.util.List;

public class ResultView {
    private static PlayLotto playLotto;
    private WinningStatistics winningStatistics;

    public Lottos showCreatedLottos(int totalLotto) {
        playLotto = new PlayLotto();

        System.out.println(totalLotto + "개를 구매했습니다.");

        Lottos createdLottos = playLotto.autoCreateLottos(totalLotto);

        for (Lotto lotto : createdLottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }

        return createdLottos;
    }

    public void showWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto, int money) {
        System.out.println("당첨 통계\n---------");

        Counts counts = playLotto.getWinningStatistics(createdLottos, lastWinningLotto);

        winningStatistics = new WinningStatistics();

        for (int i = 0; i < counts.getCounts().size(); i++) {
            System.out.println(winningStatistics.getWinningTypes().get(i).getCorrespond() + "- " + counts.getCounts().get(i) + "개");
        }

        printYield(counts, winningStatistics, money);
    }

    public void printYield(Counts counts, WinningStatistics winningStatistics, int money) {
        int sum = 0;

        for (int i = 0; i < counts.getCounts().size(); i++) {
            sum += counts.getCounts().get(i) * winningStatistics.getWinningTypes().get(i).getWinningAmount();
        }

        double yield = (double) Math.round(sum * 100 / money) / 100.0;

        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
