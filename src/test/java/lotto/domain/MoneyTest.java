package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 투입한_금액으로_로또를_몇_개_살_수_있는지를_알_수_있다() {
        final Money money = new Money(3000);

        final int amount = money.divideByLottoPrice();

        assertThat(amount).isEqualTo(3);
    }

}
