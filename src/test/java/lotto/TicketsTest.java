package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TicketsTest {

    @Test
    @DisplayName("입력받은 로또 개수만큼 로또를 생성한다")
    void createTickets() {
        //given
        int purchaseQuantity = 14;

        //when
        Tickets tickets = new Tickets(purchaseQuantity, new RandomNumberGeneration());

        //then
        assertThat(tickets.size()).isEqualTo(purchaseQuantity);
    }

}