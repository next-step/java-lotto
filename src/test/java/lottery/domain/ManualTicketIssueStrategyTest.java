package lottery.domain;

import lottery.Constant;
import lottery.strategy.ManualTicketIssueStrategy;
import lottery.strategy.TicketIssueStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ManualTicketIssueStrategyTest {
    @Test
    @DisplayName("수동 티켓 발급")
    void issue() {
        // given
        List<Integer> manualLotteryInt = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LotteryNumber> manualLotteryNumbers = manualLotteryInt.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        TicketIssueStrategy ticketIssueStrategy = new ManualTicketIssueStrategy(manualLotteryInt);

        // when
        LotteryTicket lotteryTicket = ticketIssueStrategy.issue();

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(Constant.LOTTERY_TICKET_SIZE);
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(manualLotteryNumbers));
    }
}