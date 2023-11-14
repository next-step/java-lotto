package step2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import step2.constant.Prize;
import step2.domain.Actor;
import step2.domain.LotteryMachine;
import step2.domain.StatisticsMachine;
import step2.model.Lotteries;
import step2.model.Lottery;
import step2.view.InputView;
import step2.view.ResultView;

public class LotteryAutoNumberGenerator {

    public static void main(String[] args) {
        Actor actor = new Actor();
        Lotteries lotteries = new Lotteries();
        LotteryMachine lotteryMachine = new LotteryMachine();
        StatisticsMachine statisticsMachine = new StatisticsMachine();

        int money = InputView.start();
        int ticketCount = lotteryMachine.getTicketCount(money);
        InputView.showTicketCount(ticketCount);

        for (int i = 0; i < ticketCount; i++) {
            lotteryMachine.run();
            lotteryMachine.shuffle();
            Lottery lottery = Lottery.of(lotteryMachine.getBall(actor.choose()));
            lotteries.keep(lottery);
        }
        InputView.showActorLotteries(lotteries.getLotteries());

        List<Prize> pirzeList = lotteries.getPirzeList(InputView.getWinning());

        Map<String, Integer> sortedPrize = statisticsMachine.sortPrize(pirzeList);
        long rewards = statisticsMachine.getRewards(sortedPrize);
        BigDecimal roi = statisticsMachine.getRoi(money, rewards);

        ResultView.showRewards(sortedPrize);
        ResultView.showRoi(roi);
    }
}
