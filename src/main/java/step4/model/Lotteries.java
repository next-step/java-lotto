package step4.model;

import java.util.ArrayList;
import java.util.List;

import step4.domain.Lottery;
import step4.util.LotteryUtil;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    private void keep(Lottery lottery) {
        lotteries.add(lottery);
    }

    public void generateManualLottery(List<List<Integer>> manualNumbers) {
        for (List<Integer> numbers : manualNumbers) {
            Lottery lottery = Lottery.of(numbers);
            keep(lottery);
        }
    }

    public void generateAutoLottery(int ticketCount) {
        for (int ticket = 0; ticket < ticketCount; ticket++) {
            Lottery lottery = Lottery.of(LotteryUtil.getBall());
            keep(lottery);
        }
    }
}
