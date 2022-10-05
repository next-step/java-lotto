package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.NullTicketsException;
import lotto.domain.exception.OutOfTicketIndexException;
import lotto.domain.number.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class TicketBoxTest {

    @ParameterizedTest
    @MethodSource("getInitTicketBoxTestArguments")
    @DisplayName("주어진 티켓들로 티켓 박스 생성.")
    void init_ticket_box(List<Ticket> tickets, int expected) {
        assertThat(new TicketBox(tickets).getSize())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("티켓박스에 넣을 티켓뭉치가 null 일 경우 예외 발생.")
    void fail_to_init_ticket_box_by_null_tickets(List<Ticket> tickets) {
        assertThatExceptionOfType(NullTicketsException.class)
                .isThrownBy(() -> new TicketBox(tickets));
    }

    @Test
    @DisplayName("원하는 위치의 티켓 가져오기")
    void get_ticket() {
        TicketBox ticketBox = new TicketBox(
                List.of(
                        new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                        new Ticket(List.of(3, 5, 12, 14, 15, 17))
                )
        );

        assertThat(ticketBox.getTicket(1)
                .getNumbers())
                .containsExactly(3, 5, 12, 14, 15, 17);
    }

    @Test
    @DisplayName("티켓 수를 넘어가는 인덱스로 원하는 위치의 티켓 가져오기 시도 시 예외 발생.")
    void fail_to_get_ticket_by_invalid_index() {
        TicketBox ticketBox = new TicketBox(
                List.of(
                        new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                        new Ticket(List.of(3, 5, 12, 14, 15, 17))
                )
        );

        assertThatExceptionOfType(OutOfTicketIndexException.class)
                .isThrownBy(() -> ticketBox.getTicket(2));
    }


    private static Stream<Arguments> getInitTicketBoxTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new Ticket(List.of(1, 2, 3, 4, 5, 6)),
                                new Ticket(List.of(3, 5, 12, 14, 15, 17))
                        ),
                        2
                ),
                Arguments.arguments(
                        new ArrayList<>(),
                        0
                )
        );
    }
}