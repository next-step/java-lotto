package lotto.ui;

import lotto.objects.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public void showCreatedLottos(LottoMachine lottoMachine, Lottos createdLottos) {
        Print.printPurchase(lottoMachine.getTotal());

        for (Lotto lotto : createdLottos.getLottos()) {
            Print.printLottoNumbers(lotto);
        }
    }

    public void showWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto, Money money, BonusBall bonusBall) {
        Print.printStatistics();

        Matching matching = new Matching(createdLottos, lastWinningLotto, bonusBall);
        List<WinningType> wins = matching.getWinningStatistics();

        Map<Object, Long> result = wins.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        WinningType[] winningTypes = WinningType.values();
        for (WinningType winningType : winningTypes) {
            Print.printResult(winningType, result);
        }

        Print.printYield(result, money);
    }
}
