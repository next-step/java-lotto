package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    void name() {
        Money money = Money.buy(14000);
        assertThat(money).isEqualTo(Money.buy(14000));
    }

    @Test
    void not_zero_or_negative() {
        assertThatThrownBy(() -> Money.buy(0))
                .isInstanceOf(IllegalArgumentException.class) ;

        assertThatThrownBy(() -> Money.buy(-1))
                .isInstanceOf(IllegalArgumentException.class) ;
    }

    @Test
    void divide() {
        Money money = Money.buy(14000);
        int divide = money.divide(1000);
        assertThat(divide).isEqualTo(14);

    }
}
