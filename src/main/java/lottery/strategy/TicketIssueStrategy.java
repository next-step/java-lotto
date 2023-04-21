package lottery.strategy;

import lottery.domain.LotteryTicket;

@FunctionalInterface
public interface TicketIssueStrategy {
    LotteryTicket issue();
}
