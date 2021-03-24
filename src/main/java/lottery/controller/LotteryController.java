package lottery.controller;

import lottery.domain.*;
import lottery.dto.LotteryNumbersDto;
import lottery.dto.RoundResult;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class LotteryController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        LotteryTicketOrder order = new LotteryTicketOrder(inputView.receiveLotteryTicketOrder());
        LotteryTicket lotteryTicket = LotteryTicketIssuer.issue(order);

        List<LotteryNumbersDto> lotteryNumbersDtoList = lotteryTicket.exportLotteryNumbers();
        int amountOfManualLotteries = order.getAmountOfManualLotteries();
        int amountOfAutomaticLotteries = lotteryNumbersDtoList.size() - amountOfManualLotteries;

        resultView.printLotteryAmounts(amountOfManualLotteries, amountOfAutomaticLotteries);
        resultView.printLotteryNumbers(lotteryNumbersDtoList);

        LotteryNumbers winningNumbers = new LotteryNumbers(inputView.receiveWinningNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(inputView.receiveBonusNumber());
        WinningLottery winningLottery = new WinningLottery(winningNumbers, bonusNumber);

        RoundResult roundResult = lotteryTicket.getResult(winningLottery);
        resultView.printResult(roundResult);
    }

}
