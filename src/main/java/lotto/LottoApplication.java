package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();

        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(inputView.inputAmount()));
        outputView.printTickets(lottoMachine.getTickets());

        LottoTicket winningTicket = new LottoTicket(inputView.inputWinningNumbers());
        outputView.printStatistic(lottoMachine.getRankStatistics(winningTicket));
        outputView.printIncomeRatio(lottoMachine.getReturnRate(winningTicket));
    }
}
