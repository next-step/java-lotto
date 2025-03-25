package lotto;

import lotto.domain.model.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.model.LottoResult;
import lotto.domain.LottoResultCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoApplication() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start() {
        try {
            int amount = inputView.inputPurchaseAmount();
            List<LottoTicket> lottoTickets = new LottoTicketMachine().purchaseTickets(amount);

            resultView.printTickets(lottoTickets);

            LottoTicket winingLottoTicket = new LottoTicket(inputView.inputWinningNumbers());
            LottoResult lottoResult = new LottoResultCalculator().calculate(lottoTickets, winingLottoTicket);

            resultView.printResult(lottoResult, amount);
        } finally {
            inputView.close();
        }
    }

    public static void main(String[] args) {
        new LottoApplication().start();
    }
}
