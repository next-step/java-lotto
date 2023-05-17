package lottery;

import lottery.domain.*;
import lottery.view.*;

import java.util.List;

public class Main {
    private static final PriceInputView priceInputView = new PriceInputView();
    private static final NumberOfLotteryOutputView numberOfLotteryOutputView = new NumberOfLotteryOutputView();
    private static final WinLotteryInputView winLotteryInputView = new WinLotteryInputView();
    private static final LotteryResultOutputView lotteryResultOutputView = new LotteryResultOutputView();

    public static void main(String[] args) {
        Integer price = priceInputView.receive();
        LotteryStrategy lotteryStrategy = new RandomLotteryStrategy();
        List<Lottery> lotteries = Lotteries.buy(price, lotteryStrategy);
        numberOfLotteryOutputView.print(lotteries);
        Lottery winLottery = winLotteryInputView.receive();
        LotteryResult lotteryResult = Lotteries.calculateResult(lotteries, winLottery);
        lotteryResultOutputView.print(lotteryResult);
    }
}
