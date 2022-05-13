package lotto;

public class LotteryApp {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        Money money = lotteryController.scanMoney();
        lotteryController.createLotteries(money);
        lotteryController.printLotteries();
        Winning winning = new Winning(lotteryController.scanAnswer(), lotteryController.scanBonus());
        lotteryController.saveWins(lotteryController.findWins(winning));
        lotteryController.printWinStatistics();
        lotteryController.printEarningRate(money);
        lotteryController.printEarned();
    }
}
