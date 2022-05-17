package lotto.controller;

public class LotteryApp {
    public static void main(String[] args) throws Exception {
        try {
            LotteryController lotteryController = new LotteryController();
            lotteryController.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}