package lotto;

import lotto.domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TicketTest {

    @Test
    void 티켓_길이_검사() {
        Ticket ticket = new Ticket();
        Assertions.assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_매칭() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Ticket ticket1 = new Ticket(numbers);
        Ticket ticket2 = new Ticket(numbers);

        Assertions.assertThat(ticket1.matchCount(ticket2)).isEqualTo(6);
    }
}
