package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketAutoGeneratorTest {
    @Test
    void generate_lottery_ticket() {
        assertThat(new LotteryTicketAutoGenerator().generate()).isInstanceOf(LotteryTicket.class);
    }
}
