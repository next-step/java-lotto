package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
    private final static String MESSAGE_LOTTO_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    public void run() {
        Money money = new Money(InputView.enterPurchasingAmount());

        long lottoManualCount = InputView.enterLottoManualCount();

        Lottos lottos = new Lottos();
        enterLottoManualNumbers(lottoManualCount);
        for (int i = 0; i < lottoManualCount; i++) {
            lottos.addLotto(LottoStore.purchase(InputView.enterLottoManualNumbers()));
        }

        money.reduction(lottoManualCount);
        lottos.addLottos(LottoStore.purchase(money));

        ResultView.printLottos(lottos, lottoManualCount);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }

    public void enterLottoManualNumbers(long lottoManualCount) {
        if (lottoManualCount > 0) {
            System.out.println();
            System.out.println(MESSAGE_LOTTO_MANUAL_NUMBERS);
        }
    }

}
