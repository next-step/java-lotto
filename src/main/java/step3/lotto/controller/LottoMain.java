package step3.lotto.controller;

import java.util.List;
import step3.lotto.model.LottoMachine;
import step3.lotto.model.LottoNumber;
import step3.lotto.model.LottoPrize;
import step3.lotto.model.LottoResult;
import step3.lotto.model.LottoTicket;
import step3.lotto.model.LottoTicketList;
import step3.lotto.model.Money;
import step3.lotto.view.InputView;
import step3.lotto.view.ResultView;

public class LottoMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();
    private final static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        Money purchaseAmount = new Money(inputView.getPurchaseAmount());
        LottoTicketList lottoTickets = lottoMachine.buyLottoTickets(purchaseAmount);
        resultView.printLottoTicketCount(lottoTickets);

        LottoTicket lastWeekWinningTicket = new LottoTicket(inputView.getLastWeekWinningNumbers());
        LottoNumber bonusLottoNumber = LottoNumber.of(inputView.getBonusNumber());
        resultView.printLottoResultTitle();

        LottoResult lottoResult = lottoTickets.scratchAll(lastWeekWinningTicket, bonusLottoNumber);
        resultView.printLottoResult(lottoResult, purchaseAmount);
    }

}
