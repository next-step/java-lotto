package lotto;

import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.WinningPrize;
import lotto.domain.sales.LottoBill;
import lotto.domain.sales.LottoBundle;
import lotto.domain.sales.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleLottoSalesStore {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoBill bill = inputView.lottoBill();
        LottoBundle lottoBundle = LottoBundle.of(bill.quantity());

        ResultView resultView = new ResultView();
        resultView.show(lottoBundle);

        Lotto lastWinningLotto = inputView.lastWinningLotto();
        LottoNumber bonusNumber = inputView.bonusNumber();
        WinningPrize winningPrize = lottoBundle.winningPrize(new WinningLotto(lastWinningLotto, bonusNumber));
        resultView.report(winningPrize, bill);
    }
}
