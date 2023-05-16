package lottery;

public class LotteryController {
    private final LotteryStand lotteryStand = new LotteryStand();
    private final LotteryView lotteryView = new LotteryView();

    public void runLotterySequence() {
        var amount = lotteryView.getBuyAmount();
        var lotteries = lotteryStand.buyLotteriesOfAmount(amount);
        lotteryView.showBuyResult(lotteries);

        var winningNumbers = lotteryView.getWinningNumbers();
        var bonusNumber = lotteryView.getBonusNumber();
        var drawResult = DrawResult.fromWinningNumbersAndBonus(winningNumbers, bonusNumber);
        var statistics = new LotteryStatistics(lotteries, drawResult);
        lotteryView.showStatistics(statistics);
    }
}
