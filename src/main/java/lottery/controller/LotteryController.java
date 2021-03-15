package lottery.controller;

import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketIssuer;
import lottery.dto.RoundResult;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class LotteryController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        int money = inputView.receivePurchaseAmount();
        LotteryTicket lotteryTicket = LotteryTicketIssuer.issue(money);
        resultView.printLotteryTicket(lotteryTicket);

        List<Integer> winningNumbers = inputView.receiveWinningNumbers();
        RoundResult roundResult = lotteryTicket.getResult(winningNumbers);
        resultView.printResult(roundResult);
    }

}
