package lottery.domain.issue;

import lottery.domain.LotteryTicket;

public interface TicketIssueStrategy {
    LotteryTicket issue();
}
