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
        String[] manuals = inputView.manuals(bill.manualCount());

        LottoBundle manualLotto = new LottoBundle(manuals);
        LottoBundle quickPickLotto = new LottoBundle(bill.quickPick());
        LottoBundle integrated = new LottoBundle(manualLotto, quickPickLotto);

        ResultView resultView = new ResultView();
        resultView.salesAmount(bill);
        resultView.show(integrated);

        Lotto lastWinningLotto = inputView.lastWinningLotto();
        LottoNumber bonusNumber = inputView.bonusNumber();
        WinningPrize winningPrize = integrated.winningPrize(new WinningLotto(lastWinningLotto, bonusNumber));
        resultView.report(winningPrize, bill);
    }
}
