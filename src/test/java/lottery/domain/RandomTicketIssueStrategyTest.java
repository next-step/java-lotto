package lottery.domain;

import lottery.domain.issue.RandomTicketIssueStrategy;
import lottery.domain.issue.TicketIssueStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lottery.domain.LotteryNumber.getAllLotteryNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class RandomTicketIssueStrategyTest {

    @Test
    @DisplayName("랜덤 티켓 발급")
    void issue() {
        // given
        TicketIssueStrategy ticketIssueStrategy = new RandomTicketIssueStrategy(getAllLotteryNumbers());

        // when
        LotteryTicket lotteryTicket = ticketIssueStrategy.issue();

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(LotteryTicket.LOTTERY_TICKET_SIZE);
    }
}