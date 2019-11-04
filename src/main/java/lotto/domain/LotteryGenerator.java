package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryGenerator {
    public List<LotteryTicket> generate(int count) {

        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(generate());
        }
        return tickets;
    }

    public LotteryTicket generate() {
        return new LotteryTicket();
    }
}
