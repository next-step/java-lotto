package step4;

import java.math.BigDecimal;
import java.util.Map;

import step4.constant.Prize;
import step4.domain.Winning;
import step4.model.Lotteries;
import step4.util.LotteryUtil;
import step4.util.StatisticsUtil;
import step4.view.InputView;
import step4.view.ResultView;

public class LotteryApplication {

    public static void main(String[] args) {
        int money = InputView.getMoney();
        int allTicketCount = InputView.getAllTicketCount(money);
        int manualTicketCount = InputView.getManualTicketCount();
        int autoTicketCount = LotteryUtil.getAutoTicketCount(allTicketCount, manualTicketCount);

        Lotteries lotteries = new Lotteries();
        lotteries.generateManualLottery(InputView.getManualNumbers(manualTicketCount));

        LotteryUtil.prepare();
        lotteries.generateAutoLottery(autoTicketCount);

        InputView.showTicketCount(manualTicketCount, autoTicketCount);
        InputView.showLotteries(lotteries.getLotteries());

        Winning winning = Winning.from(InputView.getBonusNumber(), InputView.getWinNumber());
        Map<Prize, Integer> summarize = StatisticsUtil.summarize(winning.getPrizes(lotteries));

        long rewards = StatisticsUtil.getRewards(summarize);
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        ResultView.showRewards(summarize);
        ResultView.showRoi(roi);
    }
}
