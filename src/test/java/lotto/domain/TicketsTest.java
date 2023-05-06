package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class TicketsTest {

    @DisplayName("수량만큼 Ticket 이 발행된다")
    @Test
    public void issue() {
        //given
        int input = 77;
        //when
        Tickets tickets = Tickets.automaticIssue(input);
        //then
        assertThat(tickets.allTickets()).as("전체 발생수량이 일치한다").hasSize(input);
    }

    @DisplayName("Ticket 추가하면 수량이 1장 늘어난다")
    @Test
    public void addTicket() {
        //given
        Tickets ticketsA = new Tickets(List.of(Ticket.auto(), Ticket.auto()));
        Tickets ticketsB = new Tickets(List.of(Ticket.auto(), Ticket.auto(), Ticket.auto()));
        //when
        ticketsA.add(ticketsB);
        //then
        assertAll("",
                () -> assertThat(ticketsA.allTickets()).as("2장+3장이므로 총 5장이 나와야 한다").hasSize(5),
                () -> assertThat(ticketsB.allTickets()).as("3장을 그대로 유지한다").hasSize(3)
        );
    }

    @DisplayName("Tickets 추가하면 수량이 추가한 Tickets 만큼 늘어난다")
    @Test
    public void addTickets() {
        //given
        Tickets tickets = new Tickets(List.of(Ticket.auto(), Ticket.auto()));
        Ticket ticket = Ticket.auto();
        //when
        tickets.add(ticket);
        //then
        assertAll("",
                () -> assertThat(tickets.allTickets()).as("2장+1장이므로 총 3장이 나와야 한다").hasSize(3),
                () -> assertThat(tickets.count()).as("3이 리턴된다").isEqualTo(3)
        );
    }
}