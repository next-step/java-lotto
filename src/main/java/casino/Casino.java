package casino;

import lottery.Lottery;

import java.util.ArrayList;
import java.util.List;

public class Casino {
    private static final int LOTTERY_UNIT = 1000;

    public Lottery buyLottery2() {
        return new Lottery();
    }
    public List<Lottery> buyLottery(int money) {
        if (money < LOTTERY_UNIT) {
            throw new IllegalArgumentException("로또는 1장에 1000원입니다");
        }
        List<Lottery> lotteryTickets = new ArrayList<>();
        int enableTicketCount = money/1000;
        for(int i=0; i < enableTicketCount; i++ ) {
            lotteryTickets.add(new Lottery());
        }
        return lotteryTickets;
    }


}
