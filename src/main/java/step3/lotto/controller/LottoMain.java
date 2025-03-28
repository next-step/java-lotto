package step3.lotto.controller;

import java.util.List;
import step3.lotto.model.Count;
import step3.lotto.model.LottoMachine;
import step3.lotto.model.LottoMatchCount;
import step3.lotto.model.LottoResult;
import step3.lotto.model.LottoTicket;
import step3.lotto.model.Money;
import step3.lotto.view.InputView;
import step3.lotto.view.ResultView;

public class LottoMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        String purchaseAmount = inputView.getPurchaseAmount();
        Money money = new Money(purchaseAmount);

        LottoMachine lottoMachine = new LottoMachine();
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets(money);
        resultView.printLottoTicketCount(lottoTickets);

        String winningNumbers = inputView.getLastWeekWinningNumbers();
        LottoTicket lastWeekWinningTicket = new LottoTicket(winningNumbers);

        LottoResult lottoResult = new LottoResult();
        resultView.printLottoResultTitle();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoMatchCount matchCount = lottoTicket.match(lastWeekWinningTicket);
            lottoResult.reflect(matchCount);
        }
        resultView.printLottoResult(lottoResult);

        Money prizeMoney = lottoResult.prizeMoney();
        double rateOfReturn = (double) prizeMoney.value() / money.value();
        resultView.printRateOfReturn(rateOfReturn);
    }

}
