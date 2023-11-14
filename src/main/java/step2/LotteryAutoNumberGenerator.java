package step2;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import step2.constant.Prize;
import step2.model.Lotteries;
import step2.model.Lottery;
import step2.view.InputView;
import step2.view.ResultView;

public class LotteryAutoNumberGenerator {

    public static final int TICKET_PRICE = 1000;

    public static void main(String[] args) {
        Actor actor = new Actor();
        Lotteries lotteries = new Lotteries();
        LotteryMachine lotteryMachine = new LotteryMachine();
        StatisticsMachine statisticsMachine = new StatisticsMachine();

        int ticketCount = InputView.start();
        for (int i = 0; i < ticketCount; i++) {
            lotteryMachine.run();
            Lottery lottery = Lottery.of(lotteryMachine.getBall(actor.choose()));
            lotteries.keep(lottery);
        }

        InputView.showActorLotteries(lotteries.getLotteries());

        List<Prize> pirzeList = lotteries.getPirzeList(InputView.getWinning());
        Map<String, Integer> sortedPrize = statisticsMachine.sortPrize(pirzeList);
        long rewards = statisticsMachine.getRewards(sortedPrize);

        ResultView.showRewards(sortedPrize);

        int invest = ticketCount * TICKET_PRICE;
        BigDecimal roi = new BigDecimal(rewards).divide(new BigDecimal(invest), HALF_UP)
                                                .setScale(2, HALF_UP);

        ResultView.showRoi(roi);
    }
}
