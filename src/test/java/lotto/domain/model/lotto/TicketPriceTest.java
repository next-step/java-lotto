package lotto.domain.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketPriceTest {

    @DisplayName("표준 티켓 가격 생성 테스트")
    @Test
    void createStandardTicketPrice() {
        TicketPrice ticketPrice = TicketPrice.standard();

        assertThat(ticketPrice.getPrice()).isEqualTo(1000);
    }

    @DisplayName("티켓 가격 동등성 테스트")
    @Test
    void ticketPriceEquality() {
        TicketPrice price1 = TicketPrice.standard();
        TicketPrice price2 = TicketPrice.standard();

        assertThat(price1).isEqualTo(price2);
        assertThat(price1.hashCode()).isEqualTo(price2.hashCode());
    }
} 
