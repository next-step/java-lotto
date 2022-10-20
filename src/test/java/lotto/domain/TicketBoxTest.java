package lotto.domain;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.InvalidTicketsException;
import lotto.domain.exception.NullTicketBoxException;
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
    @MethodSource("getInvalidTicketList")
    @DisplayName("티켓박스에 넣을 티켓뭉치가 null 이거나 중복 티켓을 포함할 경우 예외 발생.")
    void fail_to_init_ticket_box_by_invalid_tickets(List<Ticket> tickets) {
        assertThatExceptionOfType(InvalidTicketsException.class)
                .isThrownBy(() -> new TicketBox(tickets));
    }

    @ParameterizedTest
    @MethodSource("mergeTicketBoxes")
    @DisplayName("티켓박스 두개를 하나로 합치기.")
    void merge_ticket_boxes(TicketBox ticketBox1, TicketBox ticketBox2, int expected) {
        TicketBox mergeTicketBox = TicketBox.merge(ticketBox1, ticketBox2);
        assertThat(mergeTicketBox.getSize()).isEqualTo(expected);
    }

    @Test
    @DisplayName("합칠 티켓박스 중 null 이 있으면 예외 발생.")
    void fail_to_merge_ticket_boxes_by_null_box() {
        assertThatExceptionOfType(NullTicketBoxException.class)
                .isThrownBy(() -> TicketBox.merge(new TicketBox(new ArrayList<>()), null));
    }

    private static Stream<Arguments> getInitTicketBoxTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                getTicket(List.of(1, 2, 3, 4, 5, 6)),
                                getTicket(List.of(3, 5, 12, 14, 15, 17))
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
        Ticket ticket = getTicket(List.of(1, 2, 3, 4, 5, 6));

        return Stream.of(Arguments.arguments(List.of(ticket, ticket)));
    }

    private static Stream<Arguments> mergeTicketBoxes() {
        return Stream.of(
                Arguments.arguments(
                        new TicketBox(List.of(getTicket(List.of(1, 2, 3, 4, 5, 6)))),
                        new TicketBox(List.of(
                                getTicket(List.of(6, 12, 23, 24, 35, 36)),
                                getTicket(List.of(5, 7, 22, 34, 39, 45)),
                                getTicket(List.of(3, 5, 12, 14, 15, 17)))),
                        4
                ),
                Arguments.arguments(
                        new TicketBox(new ArrayList<>()),
                        new TicketBox(List.of(
                                getTicket(List.of(6, 12, 23, 24, 35, 36)),
                                getTicket(List.of(5, 7, 22, 34, 39, 45)))),
                        2
                )
        );
    }

    private static Ticket getTicket(List<Integer> numbers) {
        return new Ticket(numbersToBalls(numbers));
    }

}
