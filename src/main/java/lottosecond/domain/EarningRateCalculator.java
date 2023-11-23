package lottosecond.domain;

public class EarningRateCalculator {

    public double calculateEarningRate(WinnerBoard winnerBoard, Money money) {
        long totalPrice = winnerBoard.calculateTotalPrice();
        return Math.floor(totalPrice * 100.0 / money.getMoney()) / 100;
    }
}
