package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Ticket;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void constructor() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket).isEqualTo(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void checkPrize() {
        assertThat(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)).checkPrize(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
        assertThat(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)).checkPrize(Arrays.asList(1, 2, 3, 4, 5, 7))).isFalse();
    }

    @Test
    void checkBonusNumber() {
        assertThat(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)).checkBonusNumber(1)).isTrue();
        assertThat(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)).checkBonusNumber(7)).isFalse();
    }
}