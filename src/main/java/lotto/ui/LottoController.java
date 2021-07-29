package lotto.ui;

import lotto.domain.lotto.LottoBunch;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.MatchResult;
import lotto.domain.money.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        Money money = InputView.inputPurchaseMoney();
        LottoBunch lottoBunch = LottoService.purchase(money);

        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = LottoService.matchWinningNumber(lottoBunch, winningLotto);

        ResultView.printLottos(lottoBunch);
        ResultView.printMatchResult(matchResult);
    }

}