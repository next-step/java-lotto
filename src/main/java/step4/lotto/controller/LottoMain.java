package step4.lotto.controller;

import step4.lotto.model.Count;
import step4.lotto.model.LottoMachine;
import step4.lotto.model.LottoNumber;
import step4.lotto.model.LottoResult;
import step4.lotto.model.LottoTicket;
import step4.lotto.model.LottoTicketList;
import step4.lotto.model.LottoTicketWinner;
import step4.lotto.model.Money;
import step4.lotto.view.InputView;
import step4.lotto.view.ResultView;

public class LottoMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();
    private final static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        Money purchaseAmount = new Money(inputView.getPurchaseAmount());
        Count manualLottoTicketCount = new Count(inputView.getManualLottoTicketCount());
        lottoMachine.validateBuyLottoTickets(purchaseAmount, manualLottoTicketCount);

        inputView.printManualLottoNumbersTitle();
        LottoTicketList lottoTickets = lottoMachine.buyLottoTickets(purchaseAmount, inputView.getManualLottoNumbersList(manualLottoTicketCount));
        resultView.printLottoTicketCount(lottoTickets);

        LottoTicketWinner lastWeekWinningTicket = new LottoTicketWinner(
            new LottoTicket(inputView.getLastWeekWinningNumbers()), LottoNumber.of(inputView.getBonusNumber()));

        resultView.printLottoResultTitle();
        LottoResult lottoResult = lottoTickets.scratchAll(lastWeekWinningTicket);
        resultView.printLottoResult(lottoResult, purchaseAmount);
    }

}
