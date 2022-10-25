package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {
    public static void start() {
        int inputMoney = InputView.getMoney();

        Lottos lottos = LottoGameService.getLottos(inputMoney);
        ResultView.printLottos(lottos);

        Lotto winnings = new Lotto(InputView.getWinningNumbers());

        List<LottoResult> results = LottoGameService.getResults(lottos, winnings);
        ResultView.printResults(results);
        ResultView.printYield(LottoGameService.calculateYield(inputMoney, WinningsCalculator.calculateWinnings(results)));
    }
}
