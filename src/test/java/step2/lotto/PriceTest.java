package step2.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Price")
class PriceTest {

    @Test
    @DisplayName("should be equal when amount is same")
    void shouldBeEqualWhenAmountIsSame() {
        Price price = new Price(1000);
        assertThat(price).isEqualTo(new Price(1000));
    }

    @Test
    @DisplayName("should be equal when amount, unit is same")
    void shouldBeEqualWhenAmountAndUnitIsSame() {
        Price price = new Price(1000, Price.Unit.WON);
        assertThat(price).isEqualTo(new Price(1000));
    }
}