package step3;

import java.math.BigDecimal;
import java.util.Map;

import step3.constant.Prize;
import step3.domain.Lottery;
import step3.domain.Winning;
import step3.model.Lotteries;
import step3.util.LotteryUtil;
import step3.util.StatisticsUtil;
import step3.view.InputView;
import step3.view.ResultView;

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

        lotteries.setWin(InputView.getWinNumber());
        Winning winning = Winning.from(InputView.getBonusNumber());
        Map<Prize, Integer> summarize = StatisticsUtil.summarize(winning.getPrizes(lotteries));

        long rewards = StatisticsUtil.getRewards(summarize);
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        ResultView.showRewards(summarize);
        ResultView.showRoi(roi);
    }
}
