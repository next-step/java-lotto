package lotto.domain;

import java.util.List;

public class LotteryBuyer {
    private static final int LOTTO_PRICE = 1000;

    private final int autoLotteryCount;

    public static LotteryBuyer of(int totalPurchaseAmount, int manualLotteryCount) {
        if (totalPurchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000 이상이어야 합니다");
        }

        if (LOTTO_PRICE * manualLotteryCount > totalPurchaseAmount) {
            throw new IllegalArgumentException("수동 구매 수량의 가격이 구입금액을 초과했습니다");
        }

        int autoLotteryCount = calculateAutoLottoCount(totalPurchaseAmount, manualLotteryCount);

        return new LotteryBuyer(autoLotteryCount);
    }

    public LotteryBuyer(int autoLotteryCount) {
        this.autoLotteryCount = autoLotteryCount;
    }

    private static int calculateAutoLottoCount(int totalPurchaseAmount, int manualLottoCount) {
        int manualLottoPurchaseAmount = LOTTO_PRICE * manualLottoCount;
        return (totalPurchaseAmount - manualLottoPurchaseAmount) / LOTTO_PRICE;
    }

    public Lotteries purchaseLotteries(List<Lottery> manualLotteries) {
        return new Lotteries(manualLotteries, autoLotteryCount);
    }
}
