package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryRound {
    private final LotteryTicket prizeTicket;

    public LotteryRound(LotteryTicket prizeTicket) {
        this.prizeTicket = prizeTicket;
    }

    public List<LotteryPrize> matches(List<LotteryTicket> tickets) {
        return tickets.stream()
                .map(this::match)
                .collect(Collectors.toList());
    }

    public LotteryPrize match(LotteryTicket ticket) {
        int matchingCount = prizeTicket.match(ticket);

        return LotteryPrize.of(matchingCount);
    }
}
