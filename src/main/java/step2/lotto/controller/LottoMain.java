package step2.lotto.controller;

import java.util.stream.IntStream;
import step2.lotto.model.Count;
import step2.lotto.model.LottoResult;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;
import step2.lotto.model.PrizeMoney;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class LottoMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        String purchaseAmount = inputView.getPurchaseAmount();
        Money money = new Money(purchaseAmount);

        LottoApp lottoApp = new LottoApp();
        LottoTicketList lottoTicketList = lottoApp.buyLottoTickets(money);
        resultView.printLottoTicketCount(lottoTicketList);

        String winningNumbers = inputView.getLastWeekWinningNumbers();
        LottoTicket lastWeekWinningTicket = new LottoTicket(winningNumbers);

        LottoResult lottoResult = new LottoResult();
        resultView.printLottoResultTitle();
        for (LottoTicket lottoTicket : lottoTicketList.value()) {
            Count matchCount = lottoTicket.match(lastWeekWinningTicket);
            lottoResult.reflect(matchCount);
        }
        resultView.printLottoResult(lottoResult);

        Money prizeMoney = lottoResult.prizeMoney();
        double rateOfReturn = (double) prizeMoney.value() / money.value();
        resultView.printRateOfReturn(rateOfReturn);
    }

}
