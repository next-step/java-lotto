package step2;

import java.math.BigDecimal;
import java.util.Map;

import step2.util.LotteryUtil;
import step2.util.StatisticsUtil;
import step2.model.Lotteries;
import step2.domain.Lottery;
import step2.domain.Winning;
import step2.view.InputView;
import step2.view.ResultView;

public class LotteryAutoNumberGenerator {

    public static void main(String[] args) {
        int money = InputView.start();
        int ticketCount = InputView.getTicketCount(money);
        InputView.showTicketCount(ticketCount);

        Lotteries lotteries = new Lotteries();
        for (int i = 0; i < ticketCount; i++) {
            Lottery lottery = Lottery.of(LotteryUtil.getBall());
            lotteries.keep(lottery);
        }
        InputView.showLotteries(lotteries.getLotteries());
        Winning winning = Winning.from(InputView.getWinNumber());

        Map<String, Integer> summarize = StatisticsUtil.summarize(winning.getPirzeList(lotteries));
        long rewards = StatisticsUtil.getRewards(summarize);
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        ResultView.showRewards(summarize);
        ResultView.showRoi(roi);
    }
}
