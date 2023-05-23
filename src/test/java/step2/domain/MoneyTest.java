package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 200, 1000, 14000})
    public void 머니_생성(int money) throws Exception {
        assertThat(new Money(money)).isEqualTo(new Money(money));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -3000})
    public void 머니_생성_예외(int money) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(money));
    }

    @ParameterizedTest
    @CsvSource(value = {"3000:1000", "10000:2000", "8500:500"}, delimiter = ':')
    public void pay(int money, int cost) throws Exception {
        Money money1 = new Money(money);
        money1.pay(cost);
        assertThat(money1.balance()).isEqualTo(money - cost);
    }


    @ParameterizedTest
    @CsvSource(value = {"3000:5000", "10000:24000", "8500:50000"}, delimiter = ':')
    public void pay_예외(int money, int cost) throws Exception {
        Money money1 = new Money(money);
        assertThatIllegalArgumentException().isThrownBy(() -> money1.pay(cost));
    }


}
