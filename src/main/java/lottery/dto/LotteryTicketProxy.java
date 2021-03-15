package lottery.dto;

import java.util.Collections;
import java.util.List;

public class LotteryTicketProxy implements ReadonlyLotteryTicket {

    private final List<ReadonlyLottery> lotteries;

    public LotteryTicketProxy(ReadonlyLotteryTicket lotteryTicket) {
        this.lotteries = lotteryTicket.getLotteries();
    }

    @Override
    public List<ReadonlyLottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }

}
