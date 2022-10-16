package lottery;

import java.util.List;

public class Customer {

    private LotteryWallet lotteryWallet = new LotteryWallet();

    public void purchaseRandomLottery() {
        List<Lottery> lotteries = lotteryWallet.getLotteries();
        lotteries.add(LotteryCompany.generateRandomLotteryNumbers());

        lotteryWallet = new LotteryWallet(lotteries);
    }

    public LotteryWallet getLotteryWallet() {
        return lotteryWallet;
    }
}
