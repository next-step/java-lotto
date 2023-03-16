package casino;

import lotto.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Casino {
    private static final int LOTTERY_UNIT = 1000;

    public Casino() {}

    public List<Lotto> buyLottery(int money) {
        if (money < LOTTERY_UNIT) {
            throw new IllegalArgumentException("로또는 1장에 1000원입니다");
        }
        List<Lotto> lottoTickets = new ArrayList<>();
        int enableTicketCount = money/LOTTERY_UNIT;
        for(int i=0; i < enableTicketCount; i++ ) {
            lottoTickets.add(LottoFactory.auto());
        }
        return lottoTickets;
    }

    public int match(Lotto userLotto, WinningLotto winningLotto) {
        return LottoGame.match(userLotto, winningLotto);
    }
}
