package lotto;

public class LotteryApp {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        lotteryController.scan();
        lotteryController.createLotteries();
        lotteryController.printLotteries();
    }
}
