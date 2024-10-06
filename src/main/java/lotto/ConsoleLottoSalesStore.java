package lotto;

import lotto.domain.number.Lotto;
import lotto.domain.prize.WinningReport;
import lotto.domain.sales.LottoBill;
import lotto.domain.sales.LottoBundle;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleLottoSalesStore {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoBill bill = inputView.sell();
        LottoBundle lottoBundle = LottoBundle.of(bill.quantity());

        ResultView resultView = new ResultView();
        resultView.show(lottoBundle);

        Lotto lastWinningLotto = inputView.lastWinningLotto();
        WinningReport winningReport = WinningReport.of(bill.salesAmount(), lottoBundle, lastWinningLotto);

        resultView.report(winningReport);
    }
}
