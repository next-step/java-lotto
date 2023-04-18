package lottery.domain.issue;

import lottery.domain.LotteryTicket;

public interface TicketIssueStrategy {
    public LotteryTicket issue();
}
