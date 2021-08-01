package lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.ManaualLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.money.PaymentInfo;
import lotto.domain.prize.MatchResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        Money money = InputView.inputPurchaseMoney();
        int countManualLotto = InputView.inputNumberOfManualLotto();
        ManaualLottos manualLottos = InputView.inputManualLottoTickets(countManualLotto);
        PaymentInfo paymentInfo = PaymentInfo.of(money, manualLottos);
        Lottos lottos = LottoService.purchase(paymentInfo, manualLottos);
        ResultView.printLottos(lottos);

        calculateWinningStatistics(money, lottos);
    }

    private static void calculateWinningStatistics(Money money, Lottos lottos) {
        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = LottoService.match(lottos, money, winningLotto);
        ResultView.printMatchResult(matchResult);
    }

}