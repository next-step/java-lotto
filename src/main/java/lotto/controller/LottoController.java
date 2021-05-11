package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public void start() {
        int inputMoney = InputView.inputMoney();
        int inputManualCounts = InputView.inputManualLottoCount();
        Money money = Money.of(inputMoney, inputManualCounts);
        List<List<Integer>> manualNumbersList = InputView.inputManualLottoNumbers(inputManualCounts);

        Lottos lottos = new Lottos(manualNumbersList.stream()
                .map(Lotto::createManualLotto)
                .collect(Collectors.toList()));
        lottos.addLottoList(Lottos.of(money).getLottos());

        ResultView.printPurchase(lottos, inputManualCounts);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LottoResult result = LottoResult.of(lottos, winningLotto);
        ResultView.printWinningResult(result);
        ResultView.printEarningRate(money, result);
    }
}
