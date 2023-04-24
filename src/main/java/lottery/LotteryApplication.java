package lottery;

import lottery.controller.LotteryController;
import lottery.domain.LotteryVendingMachine;

public class LotteryApplication {
    public static void main(String[] args) {
        LotteryVendingMachine vendingMachine = new LotteryVendingMachine();
        LotteryController lotteryController = new LotteryController(vendingMachine);
        lotteryController.sell();
    }
}
