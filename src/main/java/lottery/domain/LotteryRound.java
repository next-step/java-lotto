package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryRound {
    private final LotteryTicket prizeTicket;
    private final LotteryNumber bonusNumber;

    public LotteryRound(LotteryTicket prizeTicket, LotteryNumber bonusNumber) {
        this.prizeTicket = prizeTicket;
        this.bonusNumber = bonusNumber;
    }

    public List<LotteryPrize> matches(List<LotteryTicket> tickets) {
        return tickets.stream()
                .map(this::match)
                .collect(Collectors.toList());
    }

    public LotteryPrize match(LotteryTicket ticket) {
        int matchingCount = prizeTicket.match(ticket);
        boolean isBonusMatch = ticket.contains(bonusNumber);

        return LotteryPrize.valueOf(matchingCount, isBonusMatch);
    }
}
