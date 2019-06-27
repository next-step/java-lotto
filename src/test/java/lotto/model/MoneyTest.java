package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {15000, 15020})
    void test_getPurchaseableQuantity(int value) {
        Money money = new Money(value);
        int quantity = money.getPurchaseableQuantity();

        assertThat(quantity).isEqualTo(15);
    }

    @Test
    @DisplayName("수동구매시 돈을 감소시키기")
    void makePayment() {
        Money money = new Money(4000);
        assertThat(money.makePayment(new Quantity(2))).isEqualTo(2000);
    }
}
