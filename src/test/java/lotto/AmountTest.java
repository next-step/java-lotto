package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AmountTest {
    @Test
    void amount_under_zero() {
        assertThatThrownBy(() -> new Amount(0))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.AMOUNT_UNDER_ZERO.getMessage());
    }

    @Test
    void amount_over_zero() {
        assertThatNoException().isThrownBy(() -> new Amount(1));
    }

    @Test
    void create_lottery_ticket_with_amount() {
        LotteryTickets lotteryTickets = new Amount(2).createTickets(new LotteryTicketAutoGenerator());
        assertThat(lotteryTickets).isInstanceOf(LotteryTickets.class);
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(2);
    }
}
