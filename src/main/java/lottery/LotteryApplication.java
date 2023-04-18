package lottery;

import lottery.controller.LotteryController;

import java.util.Scanner;

public class LotteryApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController(scanner);
        lotteryController.run();
    }
}
