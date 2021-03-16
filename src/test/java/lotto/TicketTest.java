package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("구매 한 용지 = 티켓")
class TicketTest {
    Ticket ticket = new Ticket();

    @Test
    @DisplayName("구매 금액만큼의 티켓을 생성")
    void pay() {
        assertThat(ticket.generateTickes(4).size()).isEqualTo(4);
    }

    @Test
    @DisplayName("티켓들에 숫자가 입력되었는가")
    void name() {
        assertThat(ticket.generateTickes(4).get(0)).isNotEmpty();
    }

    @BeforeEach
    void init() {
        ticket = new Ticket();
    }
}