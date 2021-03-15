package lottery.domain;

import lottery.dto.LotteryProxy;
import lottery.dto.ReadonlyLottery;
import lottery.dto.ReadonlyLotteryTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket implements ReadonlyLotteryTicket {

    private final List<Lottery> lotteries;

    public LotteryTicket(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<ReadonlyLottery> getLotteries() {
        return lotteries.stream()
                        .map(LotteryProxy::new)
                        .collect(Collectors.toList());
    }
}
