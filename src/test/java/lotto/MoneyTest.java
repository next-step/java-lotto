package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(longs = {15000, 12000})
    void createMoneyTest(long input) {
        assertThat(new Money(input)).isEqualTo(new Money(input));
    }
}
