package step2;

import java.util.List;

import step2.constant.Prize;
import step2.model.Lotteries;
import step2.model.Lottery;
import step2.view.InputView;

public class LotteryAutoNumberGenerator {

    public static void main(String[] args) {
        Actor actor = new Actor();
        Lotteries lotteries = new Lotteries();
        LotteryMachine machine = new LotteryMachine();

        int ticketCount = InputView.start();
        for (int i = 0; i < ticketCount; i++) {
            machine.run();
            Lottery lottery = Lottery.of(machine.getBall(actor.choose()));
            lotteries.keep(lottery);
        }

        List<Prize> pirzeList = lotteries.getPirzeList(InputView.getWinning());
        pirzeList.forEach(prize -> System.out.print(prize.name()));
    }
}
