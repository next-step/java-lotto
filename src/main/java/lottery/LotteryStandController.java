package lottery;

public class LotteryStandController {
    public void buyLotteries() {
        var lotteryStand = new LotteryStand();
        var lotteryStandView = new LotteryStandConsoleView();

        var lotteries = lotteryStand.buyLotteriesOfAmount(lotteryStandView.getBuyAmount());
        lotteryStandView.showBuyResult(lotteries);
    }
}
