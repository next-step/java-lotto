package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Count;
import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    @DisplayName("가격은 0이상의 숫자여야 한다.")
    void priceIsPositive() {
        assertThatThrownBy(() -> new Price(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals")
    void equals() {
        Price price = new Price(1000);
        Price other = new Price(1000);
        assertThat(price.equals(other)).isTrue();
    }

    @Test
    @DisplayName("티켓 개수 계산")
    void calculateTicketCount() {
        Price price = new Price(1000);
        Price ticketPrice = new Price(100);
        assertThat(price.calcualteTicketCount(ticketPrice))
            .isEqualTo(new Count(10));
    }
}
