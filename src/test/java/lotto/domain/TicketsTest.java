package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsTest {

    private Tickets tickets;

    @BeforeEach
    public void beforeEach() {
        tickets = new Tickets();
    }

    @DisplayName("수량만큼 Ticket 이 발행된다")
    @Test
    public void issue() {
        //given
        int input = 77;
        //when
        tickets = Tickets.automaticIssue(input);
        //then
        assertThat(tickets.allTickets()).as("전체 발생수량이 일치한다").hasSize(input);
    }
}