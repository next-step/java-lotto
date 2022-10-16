package lottery;

import java.util.List;

public class LotteryCompany {

    private static final int LOTTERY_PRICE = 1000;

    public static LotteryResult createLotteryResult(Lottery wonLottery, LotteryWallet lotteryWallet) {
        List<Lottery> lotteries = lotteryWallet.getLotteries();

        LotteryResult lotteryResult = new LotteryResult(LotteryRanks.getRanksInUse(), lotteries.size(), LOTTERY_PRICE);
        lotteries.forEach(lottery -> lotteryResult.addWonCountOf(wonLottery.countEqualNumbers(lottery)));

        return lotteryResult;
    }

    public static int getAvailablePurchaseLotteryCount(int cashAmount) {
        return cashAmount / LOTTERY_PRICE;
    }
}
