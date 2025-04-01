package lotto.domain.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketCountTest {

    @DisplayName("티켓 수량 생성 테스트")
    @Test
    void createTicketCount() {
        int count = 5;
        TicketCount ticketCount = new TicketCount(count);

        assertThat(ticketCount.getCount()).isEqualTo(count);
    }

    @DisplayName("티켓 수량 유효성 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateTicketCount(int invalidCount) {
        assertThatThrownBy(() -> new TicketCount(invalidCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("티켓 수량은 0보다 커야 합니다");
    }

    @DisplayName("구매 금액으로부터 티켓 수량 생성 테스트")
    @Test
    void createFromPurchaseAmount() {
        int amount = 5000;
        TicketPrice ticketPrice = new TicketPrice(1000);
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        TicketCount ticketCount = TicketCount.from(purchaseAmount, ticketPrice);

        assertThat(ticketCount.getCount()).isEqualTo(amount / ticketPrice.getPrice());
    }
} 
