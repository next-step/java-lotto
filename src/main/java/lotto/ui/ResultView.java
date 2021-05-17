package lotto.ui;

import lotto.business.PlayLotto;
import lotto.objects.*;

public class ResultView {
    private static PlayLotto playLotto;
    private WinningStatistics winningStatistics;

    public void showCreatedLottos(int totalLotto, Lottos createdLottos) {
        playLotto = new PlayLotto();

        Print.printPurchase(totalLotto);

        for (Lotto lotto : createdLottos.getLottos()) {
            Print.printLottoNumbers(lotto);
        }
    }

    public void showWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto, int money) {
        Print.printStatistics();

        Counts counts = playLotto.getWinningStatistics(createdLottos, lastWinningLotto);

        winningStatistics = new WinningStatistics();

        for (int i = 0; i < counts.getCounts().size(); i++) {
            Print.printResult(winningStatistics, counts, i);
        }

        Print.printYield(counts, winningStatistics, money);
    }
}
