package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketsTest {
    @DisplayName("Playslip 으로부터 LotteryTicket 을 생성한다.")
    @Test
    void fromPlayslip() {
        LotteryNumber lotteryNumber = LotteryNumber.of(1, 2, 3, 4, 5, 6);
        Playslip playslip = TestingPlayslip.from(1, 3, copy(lotteryNumber, 4));

        LotteryTickets lotteryTickets = LotteryTickets.of(playslip);
        Assertions.assertThat(lotteryTickets).isEqualTo(new LotteryTickets(1, 3, copy(lotteryNumber, 4)));
    }
}
