package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Ticket;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void matchCountWithPrimitive() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket.matchCount(1)).isEqualTo(1);
    }

    @Test
    void matchCountWithIntArray() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(numbers);

        assertThat(ticket.matchCount(numbers)).isEqualTo(numbers.size());
    }

    @Test
    void checkPrize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(numbers);

        assertThat(ticket.checkPrize(numbers)).isTrue();
        assertThat(ticket.checkPrize(Arrays.asList(1, 2, 3, 4, 5, 7))).isFalse();
    }

    @Test
    void checkBonusNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(numbers);

        assertThat(ticket.checkBonusNumber(6)).isTrue();
        assertThat(ticket.checkBonusNumber(7)).isFalse();
    }
}