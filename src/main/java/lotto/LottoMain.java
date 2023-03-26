package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoMain {
    public static void main(String[] args) {

        int buyMoney = InputView.inputBuyPrice();
        LottoGame lottoGame = new LottoGame(new Money(buyMoney));

        int manualQuantity = InputView.issueManualLottos();
        lottoGame.validAvailableGenerate(manualQuantity);

        List<Set<Integer>> lottos = InputView.issueManualLottos(manualQuantity);

        List<Lotto> allManualLottos = lottoGame.generateLotto(new ManualLottoGenerator(lottos));
        List<Lotto> allAutomaticLottos = lottoGame.generateLotto(new RandomLottoGenerator(lottoGame.getAvailableQuantity()));

        ResultView.printBuyCountForPrint(allAutomaticLottos, allManualLottos);

        int[] winningNumbers1 = InputView.inputLastWeekWinningNumber();
        int bonusNumber = InputView.inputLastWeekBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(bonusNumber, winningNumbers1);
        WinningStatistics statistics = new WinningStatistics(winningNumbers, Stream.concat(allManualLottos.stream(), allAutomaticLottos.stream())
                .collect(Collectors.toList()));

        ResultView.printLottoResult(statistics);
    }
}
