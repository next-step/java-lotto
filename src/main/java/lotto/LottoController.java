package lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.MatchResult;
import lotto.domain.money.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        Money money = InputView.inputPurchaseMoney();
        Lottos lottos = LottoService.purchase(money);
        ResultView.printLottos(lottos);

        calculateWinningStatistics(money, lottos);
    }

    private static void calculateWinningStatistics(Money money, Lottos lottos) {
        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = LottoService.match(lottos, money, winningLotto);
        ResultView.printMatchResult(matchResult);
    }

}