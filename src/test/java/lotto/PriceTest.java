package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Count;
import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    @DisplayName("금액은 1000원 이상이어야 한다.")
    void priceIsPositive() {
        assertThatThrownBy(() -> new Price(1000 - 1)).isInstanceOf(IllegalArgumentException.class);
        assertThat(new Price(1000)).isNotNull();
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
        assertThat(price.calculateTicketCount())
            .isEqualTo(new Count(1));
    }

    @Test
    @DisplayName("티켓 금액 계산")
    void calculateTicketPrice() {
        assertThat(Price.calculateFromTicketCount(1))
            .isEqualTo(new Price(1000));
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateYield() {
        Price price = new Price(1000);
        Price totalPrice = new Price(2000);
        assertThat(price.calculateYield(totalPrice)).isEqualTo(0.5);
    }
}
