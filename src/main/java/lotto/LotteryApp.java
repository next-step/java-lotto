package lotto;

public class LotteryApp {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        lotteryController.scanMoney();
        lotteryController.createLotteries();
        lotteryController.printLotteries();
        Winning winning = new Winning(lotteryController.scanAnswer(), lotteryController.scanBonus());
        lotteryController.saveWins(lotteryController.findWins(winning));
        lotteryController.printWinStatistics();
        lotteryController.printEarningRate();
        lotteryController.printEarned();
    }
}
