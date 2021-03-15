package lottery.controller;

import lottery.domain.LotteryBetting;
import lottery.dto.ReadonlyLotteryTicket;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void sellLotteryTicket() {
        int money = inputView.receivePurchaseAmount();

        LotteryBetting lotteryBetting = new LotteryBetting(money);
        ReadonlyLotteryTicket lotteryTicket = lotteryBetting.getLotteryTicket();

        resultView.printLotteryTicket(lotteryTicket);
    }

}
