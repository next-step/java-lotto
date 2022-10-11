package lottery;

import java.util.List;

public class LotteryCompany {

    private static final int LOTTERY_PRICE = 1000;

    private static final int THREE_EQUAL_PRIZE = 5000;
    private static final int FOUR_EQUAL_PRIZE = 50000;
    private static final int FIVE_EQUAL_PRIZE = 1500000;
    private static final int SIX_EQUAL_PRIZE = 2000000000;

    public static LotteryResult createLotteryResult(List<Integer> lotteryNumbers, LotteryWallet lotteryWallet) {
        LotteryResult lotteryResult = new LotteryResult();
        List<Lottery> lotteries = lotteryWallet.getLotteries();

        lotteryResult.setLotteryPrice(LOTTERY_PRICE);
        lotteryResult.setTotalAmounts(lotteries.size());
        setPrizesOf(lotteryResult);
        lotteries.forEach(lottery -> lotteryResult.addWonAmountOf(lottery.countEqualNumbers(lotteryNumbers)));

        return lotteryResult;
    }

    private static void setPrizesOf(LotteryResult lotteryResult) {
        lotteryResult.setPrizeOf(3, THREE_EQUAL_PRIZE);
        lotteryResult.setPrizeOf(4, FOUR_EQUAL_PRIZE);
        lotteryResult.setPrizeOf(5, FIVE_EQUAL_PRIZE);
        lotteryResult.setPrizeOf(6, SIX_EQUAL_PRIZE);
    }

    public static int getAvailablePurchaseLotteryCount(int cashAmount) {
        return cashAmount / LOTTERY_PRICE;
    }
}
