package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {

        int buyMoney = InputView.inputBuyPrice();
        LottoGame lottoGame = new LottoGame(new Money(buyMoney));

        int manualQuantity = InputView.issueManualLottos();
        lottoGame.validAvailableGenerate(manualQuantity);

        List<Set<Integer>> lottos = InputView.issueManualLottos(manualQuantity);

        Lottos allManualLottos = lottoGame.generateLotto(new ManualLottoGenerator(lottos));
        Lottos allAutomaticLottos = lottoGame.generateLotto(new RandomLottoGenerator(lottoGame.getAvailableQuantity()));

        ResultView.printBuyCountForPrint(allAutomaticLottos, allManualLottos);

        int bonusNumber = InputView.inputLastWeekBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(bonusNumber, InputView.inputLastWeekWinningNumber());
        WinningStatistics statistics = new WinningStatistics(winningNumbers, Lottos.concat(allManualLottos, allAutomaticLottos));

        ResultView.printLottoResult(statistics);
    }
}
