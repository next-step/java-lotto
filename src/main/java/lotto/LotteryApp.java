package lotto;

public class LotteryApp {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        lotteryController.scanMoney();
        lotteryController.createLotteries();
        lotteryController.printLotteries();
        Lottery answer = lotteryController.scanAnswer();
        int bonusNumber = lotteryController.scanBonus();
        lotteryController.saveWins(lotteryController.findWins(answer, bonusNumber));
        lotteryController.printWinStatistics();
        lotteryController.printEarningRate();
        lotteryController.printEarned();
    }
}
