package lottosecond.domain;

import lottosecond.domain.lotto.Lottos;

public class EarningRateCalculator {

    public double calculateEarningRate(WinnerBoard winnerBoard, Lottos lottos) {
        long totalPrice = winnerBoard.calculateTotalPrice();
        return Math.floor(totalPrice * 100.0 / lottos.totalLottoBuyMoney()) / 100;
    }
}
