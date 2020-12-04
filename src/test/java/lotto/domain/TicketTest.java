package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket;

    @BeforeEach
    void name() {
        ticket = new Ticket(new InputMoney(10000));
    }

    @Test
    void validManualCount() {
        Assertions.assertThatThrownBy(() -> {
            ticket.setManualCount(11);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMaxCount() {
        Assertions.assertThat(ticket.getMaxCount())
                .isEqualTo(10);
    }


    @Test
    void getAutoCount() {
        ticket.setManualCount(3);
        Assertions.assertThat(ticket.getAutoCount())
                .isEqualTo(7);
    }

    @Test
    void getManualCount() {
        ticket.setManualCount(3);
        Assertions.assertThat(ticket.getManualCount())
                .isEqualTo(3);
    }
}