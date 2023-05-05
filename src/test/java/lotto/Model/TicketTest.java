package lotto.Model;

import calculator.Model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @Test
    @DisplayName("ticket create 정상 확인")
    public void ticket_create() {
        List<Integer> inputData = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketNumber expected = new TicketNumber(inputData);

        Ticket ticket = new Ticket(expected);
        TicketNumber actual = ticket.numbers();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 0개 일치 확인")
    public void ticket_match_0() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(11, 12, 13, 14, 15, 16);
        int expected = 0;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 1개 일치 확인")
    public void ticket_match_1() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 12, 13, 14, 15, 16);
        int expected = 1;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 2개 일치 확인")
    public void ticket_match_2() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 2, 13, 14, 15, 16);
        int expected = 2;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 3개 일치 확인")
    public void ticket_match_3() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 14, 15, 16);
        int expected = 3;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 4개 일치 확인")
    public void ticket_match_4() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 15, 16);
        int expected = 4;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 5개 일치 확인")
    public void ticket_match_5() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 16);
        int expected = 5;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket 6개 일치 확인")
    public void ticket_match_6() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        List<Integer> winnerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int expected = 6;

        int actual = ticket.countMatches(winnerNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket contain yes 확인")
    public void ticket_contain_yes() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        int bonusNumber = 1;
        boolean expected = true;

        boolean actual = ticket.contain(bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("ticket contain no 확인")
    public void ticket_contain_no() {
        List<Integer> inputTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(new TicketNumber(inputTicket));
        int bonusNumber = 11;
        boolean expected = false;

        boolean actual = ticket.contain(bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }
}