package lotto;

import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.WinningPrize;
import lotto.domain.sales.LottoBill;
import lotto.domain.sales.LottoBundle;
import lotto.domain.sales.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleLottoSalesStore {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoBill bill = inputView.lottoBill();
        List<String> manuals = inputView.manuals(bill.manualCount());
        LottoBundle lottoBundle = LottoBundle.of(bill.quickPick(), manuals);

        ResultView resultView = new ResultView();
        resultView.salesAmount(bill);
        resultView.show(lottoBundle);

        Lotto lastWinningLotto = inputView.lastWinningLotto();
        LottoNumber bonusNumber = inputView.bonusNumber();
        WinningPrize winningPrize = lottoBundle.winningPrize(new WinningLotto(lastWinningLotto, bonusNumber));
        resultView.report(winningPrize, bill);
    }
}
