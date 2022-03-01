package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 투입한_금액으로_로또를_몇_개_살_수_있는지를_알_수_있다() {
        final Money money = new Money(3000);

        final int amount = money.divideByLottoPrice();

        assertThat(amount).isEqualTo(3);
    }

    @Test
    void 나누기_연산이_가능하다() {
        final Money money = new Money(3000);
        final Money operand = new Money(1000);

        BigDecimal result = money.divide(operand);

        assertThat(result).isEqualTo(BigDecimal.valueOf(3));
    }

}
