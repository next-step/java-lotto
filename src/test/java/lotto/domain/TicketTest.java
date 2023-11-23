package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {
    @Test
    void test_당첨번호갯수확인() {
        Ticket ticket = new Ticket(new Numbers("1, 2, 3, 4, 5, 6"));
        assertThat(ticket.match(new Numbers("2, 3, 4, 5, 6, 7"))).isEqualTo(5);
    }
}