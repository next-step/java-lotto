package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"10000, 1000, 10", "12300, 1000, 12", "1000, 1100, 0"})
    void calculateNumberOfPurchaseTest(String money, String price, int numberOfPurchase) {
        assertThat(Money.from(money).calculateNumberOfPurchase(Money.from(price)))
                .isEqualTo(numberOfPurchase);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "15000", "50000"})
    void generateTest(String money) {
        assertThat(Money.from(money)).isEqualTo(new Money(Integer.parseInt(money)));
    }
}
