package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoenyTest {
    @ParameterizedTest
    @ValueSource(ints = { -1, -5, -10, Integer.MIN_VALUE })
    public void constructor_ShouldThrow(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(money));
    }

    @ParameterizedTest()
    @CsvSource(value = { "1000:9000", "5000:5000", "10000:0" }, delimiter = ':')
    public void purchase(int price, int balanceResult) {
        Money money = new Money(10000);
        assertThat(money.purchase(price)).isEqualTo(new Money(balanceResult));
    }

    @ParameterizedTest()
    @ValueSource(ints = { 10001, 20000, 99999999, Integer.MAX_VALUE })
    public void purchase_ShouldThrow(int price) {
        Money money = new Money(10000);
        assertThatIllegalArgumentException().isThrownBy(() -> money.purchase(price));
    }
}
