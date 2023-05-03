package lottery;

import lottery.domain.*;
import lottery.view.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer price = new PriceInputView().receive();
        LotteryStrategy lotteryStrategy = new RandomLotteryStrategy();
        List<Lottery> lotteries = Lotteries.buy(price, lotteryStrategy);
        new NumberOfLotteryOutputView().print(lotteries);
        Lottery winLottery = new WinLotteryInputView().receive();
        LotteryResult lotteryResult = Lotteries.calculateResult(lotteries, winLottery);
        new LotteryResultOutputView().print(lotteryResult);
    }
}
