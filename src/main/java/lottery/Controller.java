package lottery;

import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class Controller {

    public static void main(String[] args) {
        Customer customer = new Customer();

        int availablePurchaseAmount = LotteryCompany.availablePurchaseAmount(InputView.getTotalPurchasePrice());
        List<Lottery> manualLotteries = InputView.getManualLotteries(InputView.getManualLotteryAmount());
        customer.purchaseLotteries(availablePurchaseAmount, manualLotteries);

        List<Lottery> lotteries = customer.lotteries();
        ResultView.printLotteriesInfo(lotteries, manualLotteries.size());

        WinningLottery winningLottery = InputView.getWinningLottery();
        ResultView.printResult(winningLottery.result(lotteries));
    }

}
