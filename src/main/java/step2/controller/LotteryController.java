package step2.controller;

public class LotteryController {
    public double calculateProfitRate(double i, double i1) {
        return Math.floor(i1 / i * 100) / 100;
    }
}
