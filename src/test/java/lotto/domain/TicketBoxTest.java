package lotto.domain;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.InvalidTicketsException;
import lotto.domain.number.Ticket;
import org.junit.jupiter.api.DisplayName;
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
    @MethodSource("getInvalidTicketList")
    @DisplayName("티켓박스에 넣을 티켓뭉치가 null 이거나 중복 티켓을 포함할 경우 예외 발생.")
    void fail_to_init_ticket_box_by_invalid_tickets(List<Ticket> tickets) {
        assertThatExceptionOfType(InvalidTicketsException.class)
                .isThrownBy(() -> new TicketBox(tickets));
    }

    private static Stream<Arguments> getInitTicketBoxTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new Ticket(numbersToBalls(List.of(1, 2, 3, 4, 5, 6))),
                                new Ticket(numbersToBalls(List.of(3, 5, 12, 14, 15, 17)))
                        ),
                        2
                ),
                Arguments.arguments(
                        new ArrayList<>(),
                        0
                )
        );
    }

    private static Stream<Arguments> getInvalidTicketList() {
        Ticket ticket = new Ticket(numbersToBalls(List.of(1, 2, 3, 4, 5, 6)));

        return Stream.of(Arguments.arguments(List.of(ticket, ticket)));
    }

}
