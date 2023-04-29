package lottery.domain;

import lottery.view.PriceInputView;

public class LotteryApplication {

    public static void main(String[] args) {
        runLotteryApplication();
    }

    public static void runLotteryApplication() {
        ClientLotteryPurchasePrice clientLotteryPurchasePrice =
                PriceInputView.buyLotteries();

    }
}
