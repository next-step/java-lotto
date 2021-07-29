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
        LottoBunch lottoBunch = purchaseLottoBunch();
        calculateWinningStatistics(lottoBunch);
    }

    private static LottoBunch purchaseLottoBunch() {
        Money money = InputView.inputPurchaseMoney();
        LottoBunch lottoBunch = LottoService.purchase(money);
        ResultView.printLottos(lottoBunch);
        return lottoBunch;
    }

    private static void calculateWinningStatistics(LottoBunch lottoBunch) {
        WinningLotto winningLotto = InputView.inputWinningNumbers();
        MatchResult matchResult = LottoService.matchWinningNumber(lottoBunch, winningLotto);
        ResultView.printMatchResult(matchResult);
    }

}