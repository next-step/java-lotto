package lottery.controller;

import lottery.domain.LotteryNumberGenerator;
import lottery.domain.LotteryTickets;
import lottery.domain.PurchasePrice;

public class LotteryMachine {

    private final PurchasePrice purchasePrice;
    private final LotteryNumberGenerator lotteryNumberGenerator;

    private LotteryMachine(final PurchasePrice purchasePrice, final LotteryNumberGenerator lotteryNumberGenerator) {
        this.purchasePrice = purchasePrice;
        this.lotteryNumberGenerator = lotteryNumberGenerator;
    }

    public static LotteryMachine create(final PurchasePrice purchasePrice, final LotteryNumberGenerator lotteryNumberGenerator) {
        return new LotteryMachine(purchasePrice, lotteryNumberGenerator);
    }

    public LotteryTickets createLotteryTickets() {
        return LotteryTickets.create(purchasePrice, lotteryNumberGenerator);
    }
}
