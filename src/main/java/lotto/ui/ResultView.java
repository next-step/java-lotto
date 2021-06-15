package lotto.ui;

import lotto.business.PlayLotto;
import lotto.objects.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static PlayLotto playLotto;

    public void showCreatedLottos(int totalLotto, Lottos createdLottos) {
        playLotto = new PlayLotto();

        Print.printPurchase(totalLotto);

        for (Lotto lotto : createdLottos.getLottos()) {
            Print.printLottoNumbers(lotto);
        }
    }

    public void showWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto, int money, int bonusBallNumber) {
        Print.printStatistics();

        List<WinningType> wins = playLotto.getWinningStatistics(createdLottos, lastWinningLotto, bonusBallNumber);

        Map<Object, Long> result = wins.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        WinningType[] winningTypes = WinningType.values();
        for (WinningType winningType : winningTypes) {
            Print.printResult(winningType, result);
        }

        Print.printYield(result, money);
    }
}
