package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lottos;

public class Aggregator {

    public double calculateEarningRate(WinnerBoard winnerBoard, Lottos lottos) {
        int totalPrice = winnerBoard.calculateTotalPrice();
        return Math.floor(totalPrice * 100.0 / lottos.totalLottoBuyMoney()) / 100;
    }
}
