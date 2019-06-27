package lotto.model;

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
}
