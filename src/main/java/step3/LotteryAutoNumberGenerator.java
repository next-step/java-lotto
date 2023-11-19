package step3;

import java.math.BigDecimal;
import java.util.Map;

import step3.domain.Lottery;
import step3.domain.Winning;
import step3.model.Lotteries;
import step3.util.LotteryUtil;
import step3.util.StatisticsUtil;
import step3.view.InputView;
import step3.view.ResultView;

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
        winning.setBonusWinNumber(InputView.getWinNumber());

        Map<String, Integer> summarize = StatisticsUtil.summarize(winning.getPirzeList(lotteries));
        long rewards = StatisticsUtil.getRewards(summarize);
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        ResultView.showRewards(summarize);
        ResultView.showRoi(roi);
    }
}
