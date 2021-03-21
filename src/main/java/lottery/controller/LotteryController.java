package lottery.controller;

import lottery.domain.*;
import lottery.dto.RoundResult;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        int money = inputView.receivePurchaseAmount();
        LotteryTicket lotteryTicket = LotteryTicketIssuer.issue(money);
        resultView.printLotteryNumbers(lotteryTicket.exportLotteryNumbers());

        LotteryNumbers winningNumbers = new LotteryNumbers(inputView.receiveWinningNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(inputView.receiveBonusNumber());
        WinningLottery winningLottery = new WinningLottery(winningNumbers, bonusNumber);

        RoundResult roundResult = lotteryTicket.getResult(winningLottery);
        resultView.printResult(roundResult);
    }

}
