package casino;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Casino {
    private static final int LOTTERY_UNIT = 1000;

    public Casino() {}
    public Lotto buyLottery2() {
        return new Lotto();
    }
    public List<Lotto> buyLottery(int money) {
        if (money < LOTTERY_UNIT) {
            throw new IllegalArgumentException("로또는 1장에 1000원입니다");
        }
        List<Lotto> lottoTickets = new ArrayList<>();
        int enableTicketCount = money/1000;
        for(int i=0; i < enableTicketCount; i++ ) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }

    public void lotteryStart(HashSet<Integer> numbers, Lotto lottoTicket, int bonusNumber) {
        lottoTicket.match(numbers, bonusNumber);
    }
}
