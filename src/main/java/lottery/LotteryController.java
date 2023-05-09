package lottery;

public class LotteryController {
    private final LotteryStand lotteryStand = new LotteryStand();
    private final LotteryView lotteryView = new LotteryView();

    public void runLotterySequence() {
        var amount = lotteryView.getBuyAmount();
        var lotteries = lotteryStand.buyLotteriesOfAmount(amount);
        lotteryView.showBuyResult(lotteries);

        var winningNumbers = LotteryRow.fromCommaSpliced(lotteryView.getWinningNumbers());
        var statistics = new LotteryStatistics(lotteries, winningNumbers, LotteryStand.PRICE);
        lotteryView.showStatistics(statistics);
    }
}
