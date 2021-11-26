package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {
    @Test
    @DisplayName("3000원 만큼 자동로또 생성")
    public void toIssueLotteryTicket() {
        LotteryTickets lotteryTickets = new LotteryTickets(new Store(3000).lotteryCount());
        assertThat(lotteryTickets.size()).isEqualTo(3);
    }

}
