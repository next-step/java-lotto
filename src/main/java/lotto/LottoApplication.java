package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();

        LottoMachine lottoMachine = new LottoMachine(inputView.inputAmount());
        outputView.printTickets(lottoMachine.issue());

        LottoTicket winningTicket = new LottoTicket(inputView.inputWinningNumbers());
        outputView.printStatistic(lottoMachine.compare(winningTicket));
        outputView.printIncomeRatio(lottoMachine.calculateRevenue(winningTicket));
    }
}
