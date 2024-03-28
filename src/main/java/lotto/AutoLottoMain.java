package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class AutoLottoMain {
    public static void main(String[] args) {

        int amount = InputView.scanAmount();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        OutputView.printBuyLottos(lottos);

        List<Integer> winNumbers = InputView.scanWinningNumbers();
        IssuedLottos issuedLottos = new IssuedLottos(lottos);
        Map<WinningType, Long> winningStatic = issuedLottos.winningStatistic(winNumbers);
        OutputView.printWinningStatic(winningStatic);
        OutputView.printReturnRate(returnRate(winningStatic, amount));
    }

    private static double returnRate(Map<WinningType, Long> winningStatistic, int amount) {
        double revenue =  winningStatistic.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getRevenue() * entry.getValue())
                .reduce(0, Long::sum);
        return revenue / amount;
    }
}
