package step4;

import java.math.BigDecimal;
import java.util.Map;

import step4.constant.Prize;
import step4.domain.Lottery;
import step4.domain.Winning;
import step4.model.Lotteries;
import step4.util.LotteryUtil;
import step4.util.StatisticsUtil;
import step4.view.InputView;
import step4.view.ResultView;

public class LotteryApplication {

    public static void main(String[] args) {
        int money = InputView.start();
        int ticketCount = InputView.getTicketCount(money);
        InputView.showTicketCount(ticketCount);

        LotteryUtil.prepare();
        Lotteries lotteries = new Lotteries();
        for (int i = 0; i < ticketCount; i++) {
            Lottery lottery = Lottery.of(LotteryUtil.getBall());
            lotteries.keep(lottery);
        }
        InputView.showLotteries(lotteries.getLotteries());

        Winning winning = Winning.from(InputView.getWinNumber());
        winning.setBonusWinNumber(InputView.getBonusNumber());
        Map<Prize, Integer> summarize = StatisticsUtil.summarize(winning.getPrizes(lotteries));

        long rewards = StatisticsUtil.getRewards(summarize);
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        ResultView.showRewards(summarize);
        ResultView.showRoi(roi);
    }
}
