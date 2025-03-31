package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();

        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(inputView.inputAmount()));
        outputView.printTickets(lottoMachine.getTickets());

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers(), inputView.inputBonusNumber());
        outputView.printStatistic(lottoMachine.getRankStatistics(winningLotto));
        outputView.printIncomeRatio(lottoMachine.getReturnRate(winningLotto));
    }
}
